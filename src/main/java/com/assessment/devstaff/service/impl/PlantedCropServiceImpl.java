package com.assessment.devstaff.service.impl;

import com.assessment.devstaff.dto.PlantedCropDto;
import com.assessment.devstaff.model.Field;
import com.assessment.devstaff.model.PlantedCrop;
import com.assessment.devstaff.repository.FieldRepository;
import com.assessment.devstaff.repository.PlantedCropRepository;
import com.assessment.devstaff.service.PlantedCropService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlantedCropServiceImpl implements PlantedCropService {

    private final PlantedCropRepository plantedCropRepository;
    private final FieldRepository fieldRepository;

    @Override
    public PlantedCrop addPlantedCrop(PlantedCropDto plantedCropDto) {
        Field field = fieldRepository.findById(plantedCropDto.getFieldId()).orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + plantedCropDto.getFieldId()));

        PlantedCrop plantedCrop = new PlantedCrop();
        plantedCrop.setField(field);
        plantedCrop.setCropType(plantedCropDto.getCropType());
        plantedCrop.setSeason(plantedCropDto.getSeason());
        plantedCrop.setPlantingArea(plantedCropDto.getPlantingArea());
        plantedCrop.setExpectedProductAmount(plantedCropDto.getExpectedProductAmount());
        return plantedCropRepository.save(plantedCrop);
    }
}