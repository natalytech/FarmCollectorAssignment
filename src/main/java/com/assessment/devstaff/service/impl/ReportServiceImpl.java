package com.assessment.devstaff.service.impl;

import com.assessment.devstaff.dto.ReportDataDto;
import com.assessment.devstaff.model.HarvestedCrop;
import com.assessment.devstaff.model.PlantedCrop;
import com.assessment.devstaff.model.enums.Season;
import com.assessment.devstaff.repository.FieldRepository;
import com.assessment.devstaff.repository.HarvestedCropRepository;
import com.assessment.devstaff.repository.PlantedCropRepository;
import com.assessment.devstaff.service.ReportService;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {
    private final HarvestedCropRepository harvestedCropRepository;
    private final FieldRepository fieldRepository;
    private final PlantedCropRepository plantedCropRepository;

    public Map<String, Map<Season, ReportDataDto>> getFarmReport(){
        List<PlantedCrop> plantedCrops = plantedCropRepository.findAll();
        List<HarvestedCrop> harvestedCrops = harvestedCropRepository.findAll();

        // Group planted crops by farm and season
        Map<String, Map<Season, List<PlantedCrop>>> plantedCropsByFarmAndSeason = plantedCrops.stream()
                .collect(Collectors.groupingBy(plantedCrop -> plantedCrop.getField().getFieldId(),
                        Collectors.groupingBy(PlantedCrop::getSeason)));

        // Group harvested crops by farm
        Map<String, List<HarvestedCrop>> harvestedCropsByFarm = harvestedCrops.stream()
                .collect(Collectors.groupingBy(harvestedCrop -> harvestedCrop.getField().getFieldId()));

        // Calculate expected vs actual amount of product for each farm and season
        Map<String, Map<Season, ReportDataDto>> report = plantedCropsByFarmAndSeason.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, farmEntry -> {
                    String farmId = farmEntry.getKey();
                    Map<Season, List<PlantedCrop>> plantedCropsBySeason = farmEntry.getValue();
                    List<HarvestedCrop> harvestedCropsForFarm = harvestedCropsByFarm.getOrDefault(farmId, List.of());

                    return plantedCropsBySeason.entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getKey, seasonEntry -> {
                                Season season = seasonEntry.getKey();
                                List<PlantedCrop> plantedCropsForSeason = seasonEntry.getValue();

                                double totalExpected = plantedCropsForSeason.stream().mapToDouble(PlantedCrop::getExpectedProductAmount).sum();
                                double totalActual = harvestedCropsForFarm.stream()
                                        .filter(harvestedCrop -> plantedCropsForSeason.stream().anyMatch(plantedCrop -> plantedCrop.getPlantedId().equals(harvestedCrop.getPlantedCrop().getPlantedId())))
                                        .mapToDouble(HarvestedCrop::getActualHarvestAmount).sum();

                                return new ReportDataDto(totalExpected, totalActual);
                            }));
                }));

        return report;
    }
}
