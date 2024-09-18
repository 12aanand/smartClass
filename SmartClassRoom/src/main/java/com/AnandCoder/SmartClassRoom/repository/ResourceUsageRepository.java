package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.ResourceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ResourceUsageRepository extends JpaRepository<ResourceUsage,Long> {

    List<ResourceUsage> findByResourceId(Long resourceId);

    List<ResourceUsage> findByUserId(Long userId);

    List<ResourceUsage> findByStartTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

}
