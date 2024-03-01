package com.assessment.devstaff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportDataDto {
    private double expectedAmount;
    private double actualAmount;
}
