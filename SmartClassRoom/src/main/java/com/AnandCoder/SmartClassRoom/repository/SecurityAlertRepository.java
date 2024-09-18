package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.SecurityAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SecurityAlertRepository extends JpaRepository<SecurityAlert,Long> {

    List<SecurityAlert> findByType(String type);

    List<SecurityAlert> findByAlertTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
