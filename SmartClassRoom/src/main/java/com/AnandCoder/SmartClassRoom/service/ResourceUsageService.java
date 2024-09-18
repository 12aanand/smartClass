package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.ResourceUsage;

import java.time.LocalDateTime;
import java.util.List;

public interface ResourceUsageService {
    ResourceUsage trackResourceUsage(Long resourceId, Long userId,LocalDateTime startTime); // Track resource usage

    ResourceUsage getResourceUsageById(Long id); // Retrieve a resource usage record by ID

    List<ResourceUsage> getResourceUsageByResource(Long resourceId); // Retrieve usage records for a specific resource

    List<ResourceUsage> getResourceUsageByUser(Long userId); // Retrieve usage records for a specific user

    List<ResourceUsage> getAllResourceUsages(); // Retrieve all resource usage records

    void updateResourceUsage(Long id, LocalDateTime endTime); // Update the end time of resource usage

    List<ResourceUsage> getResourceUsageByDateRange(LocalDateTime startDate, LocalDateTime endDate); // Retrieve usage records within a specific date range

}
