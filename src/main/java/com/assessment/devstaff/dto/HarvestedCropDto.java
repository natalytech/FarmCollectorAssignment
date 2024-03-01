package com.assessment.devstaff.dto;

import lombok.Data;

@Data
public class HarvestedCropDto {
    private String fieldId;
    private String plantedId;
    private double actualHarvestAmount;
}
