package com.assessment.devstaff.dto;

import com.assessment.devstaff.model.enums.Season;
import lombok.Data;

@Data
public class PlantedCropDto {

    private String fieldId;
    private double plantingArea; // Assuming area is in acres
    private String cropType;
    private double expectedProductAmount; // Assuming product amount is in tons
    private Season season;
}
