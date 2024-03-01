package com.assessment.devstaff.controller;

import com.assessment.devstaff.dto.ReportDataDto;
import com.assessment.devstaff.model.enums.Season;
import com.assessment.devstaff.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/report")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/farm")
    public ResponseEntity<Map<String, Map<Season, ReportDataDto>>> getByFarms() {
        return ResponseEntity.ok(reportService.getFarmReport());
    }
}
