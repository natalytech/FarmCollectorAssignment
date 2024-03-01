package com.assessment.devstaff.controller;

import com.assessment.devstaff.dto.HarvestedCropDto;
import com.assessment.devstaff.dto.PlantedCropDto;
import com.assessment.devstaff.model.HarvestedCrop;
import com.assessment.devstaff.model.PlantedCrop;
import com.assessment.devstaff.service.HarvestedCropService;
import com.assessment.devstaff.service.PlantedCropService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/data-collector")
public class FarmDataCollectorController {
    private final PlantedCropService plantedCropService;
    private final HarvestedCropService harvestedCropService;

    @PostMapping("/planted")
    public ResponseEntity<String> createPlant(@RequestBody PlantedCropDto plantedCropDto) {
        PlantedCrop plantedCrop = plantedCropService.addPlantedCrop(plantedCropDto);
        return ResponseEntity.ok(plantedCrop.getPlantedId());
    }

    @PostMapping("/harvested")
    public ResponseEntity<String> createHarvest(@RequestBody HarvestedCropDto harvestedCropDto) {
        HarvestedCrop harvestedCrop = harvestedCropService.createHarvestedCrop(harvestedCropDto);
        return ResponseEntity.ok(harvestedCrop.getHarvestedId());
    }
}
