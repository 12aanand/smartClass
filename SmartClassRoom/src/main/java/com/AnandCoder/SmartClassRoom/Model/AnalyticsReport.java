package com.AnandCoder.SmartClassRoom.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
public class AnalyticsReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String reportType;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(columnDefinition = "TEXT")
    private String reportData;

    public AnalyticsReport(){

    }

    public AnalyticsReport(Long id, String reportType, LocalDate creationDate, String reportData) {
        this.id = id;
        this.reportType = reportType;
        this.creationDate = creationDate;
        this.reportData = reportData;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }
}
