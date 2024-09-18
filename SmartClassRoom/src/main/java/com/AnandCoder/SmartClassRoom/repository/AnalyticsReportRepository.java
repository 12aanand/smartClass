package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.AnalyticsReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnalyticsReportRepository extends JpaRepository<AnalyticsReport,Long> {

    List<AnalyticsReport> findByReportType(String reportType);

    List<AnalyticsReport> findByCreationDateBetween(LocalDate startDate, LocalDate endDate);
}


