package com.AnandCoder.SmartClassRoom.controller;


import com.AnandCoder.SmartClassRoom.Model.AnalyticsReport;
import com.AnandCoder.SmartClassRoom.service.AnalyticsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/analytics-reports")
public class AnalyticsReportController {

    @Autowired
    private AnalyticsReportService analyticsReportService;

    // API to generate a new report
    @PostMapping("/generate")
    public ResponseEntity<AnalyticsReport> generateReport(@RequestParam String reportType) {
        AnalyticsReport report = analyticsReportService.generateReport(reportType);
        return new ResponseEntity<>(report, HttpStatus.CREATED);
    }

    // API to get a report by ID
    @GetMapping("/{id}")
    public ResponseEntity<AnalyticsReport> getReportById(@PathVariable Long id) {
        AnalyticsReport report = analyticsReportService.getReportById(id);
        return report != null ? new ResponseEntity<>(report, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get all reports
    @GetMapping("/all")
    public ResponseEntity<List<AnalyticsReport>> getAllReports() {
        List<AnalyticsReport> reports = analyticsReportService.getAllReports();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // API to get reports by type
    @GetMapping("/type/{reportType}")
    public ResponseEntity<List<AnalyticsReport>> getReportsByType(@PathVariable String reportType) {
        List<AnalyticsReport> reports = analyticsReportService.getReportsByType(reportType);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // API to get reports by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<AnalyticsReport>> getReportsByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<AnalyticsReport> reports = analyticsReportService.getReportsByDateRange(startDate, endDate);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // API to delete a report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        analyticsReportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

