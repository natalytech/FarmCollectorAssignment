package com.assessment.devstaff.service;

import com.assessment.devstaff.dto.ReportDataDto;
import com.assessment.devstaff.model.enums.Season;

import java.util.Map;

public interface ReportService {
    Map<String, Map<Season, ReportDataDto>> getFarmReport();
}
