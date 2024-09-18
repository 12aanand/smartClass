package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.AnalyticsReport;

import java.time.LocalDate;
import java.util.List;

public interface AnalyticsReportService {
    AnalyticsReport generateReport(String reportType); // Generate a new report

    AnalyticsReport getReportById(Long id); // Retrieve a report by ID

    List<AnalyticsReport> getAllReports(); // Retrieve all reports

    List<AnalyticsReport> getReportsByType(String reportType); // Retrieve reports by type (e.g., ATTENDANCE, RESOURCE_USAGE)

    List<AnalyticsReport> getReportsByDateRange(LocalDate startDate, LocalDate endDate); // Retrieve reports within a specific date range

    void deleteReport(Long id); // Delete a report by ID
}
