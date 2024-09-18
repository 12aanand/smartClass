package com.AnandCoder.SmartClassRoom.controller;

import com.AnandCoder.SmartClassRoom.Model.*;
import com.AnandCoder.SmartClassRoom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private SecurityAlertService alertService;

    @Autowired
    private InteractiveToolFeedbackService learningToolService;

    @Autowired
    private AnalyticsReportService analyticsService;

    @Autowired
    private ResourceUsageService resourceUsageService;



    @GetMapping("/attendance")
    public List<AttendanceRecord> getAttendance() {
        return attendanceService.getAllAttendanceRecords();
    }

    @GetMapping("/resources")
    public List<Resource> getResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/security-alerts")
    public List<SecurityAlert> getAlerts() {
        return alertService.getAllSecurityAlerts();
    }

    @GetMapping("/feedback")
    public List<InteractiveToolFeedback> getLearningTools() {
        return learningToolService.getAllFeedback();
    }

    @GetMapping("/analytics-reports")
    public List<AnalyticsReport> getAnalytics() {
        return analyticsService.getAllReports();
    }
    @GetMapping("/resource-usage")
    public List<ResourceUsage> getAllResourceUsages(){
        return resourceUsageService.getAllResourceUsages();
    }


}

