package com.assessment.devstaff.service.impl;

import com.assessment.devstaff.dto.HarvestedCropDto;
import com.assessment.devstaff.model.Field;
import com.assessment.devstaff.model.HarvestedCrop;
import com.assessment.devstaff.model.PlantedCrop;
import com.assessment.devstaff.repository.FieldRepository;
import com.assessment.devstaff.repository.HarvestedCropRepository;
import com.assessment.devstaff.repository.PlantedCropRepository;
import com.assessment.devstaff.service.HarvestedCropService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HarvestedCropServiceImpl implements HarvestedCropService {
    private final HarvestedCropRepository harvestedCropRepository;
    private final FieldRepository fieldRepository;
    private final PlantedCropRepository plantedCropRepository;

    @Override
    public HarvestedCrop createHarvestedCrop(HarvestedCropDto harvestedCropDto) {
        // Retrieve the field and planted crop from repositories
        Field field = fieldRepository.findById(harvestedCropDto.getFieldId()).orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + harvestedCropDto.getFieldId()));
        PlantedCrop plantedCrop = plantedCropRepository.findById(harvestedCropDto.getPlantedId()).orElseThrow(() -> new EntityNotFoundException("Planted crop not found with id: " + harvestedCropDto.getPlantedId()));

        HarvestedCrop harvestedCrop = new HarvestedCrop();
        harvestedCrop.setField(field);
        harvestedCrop.setPlantedCrop(plantedCrop);
        harvestedCrop.setActualHarvestAmount(harvestedCropDto.getActualHarvestAmount());

        return harvestedCropRepository.save(harvestedCrop);
    }
}
