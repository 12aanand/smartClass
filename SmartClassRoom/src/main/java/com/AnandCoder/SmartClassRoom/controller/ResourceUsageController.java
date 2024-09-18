package com.AnandCoder.SmartClassRoom.controller;

import com.AnandCoder.SmartClassRoom.Model.ResourceUsage;
import com.AnandCoder.SmartClassRoom.service.ResourceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/resource-usage")
public class ResourceUsageController {

    @Autowired
    private ResourceUsageService resourceUsageService;

    // API to track resource usage
    @PostMapping("/track")
    public ResponseEntity<ResourceUsage> trackResourceUsage(
            @RequestParam Long resourceId,
            @RequestParam Long userId,
            @RequestParam LocalDateTime startTime) {
        ResourceUsage resourceUsage = resourceUsageService.trackResourceUsage(resourceId, userId,startTime);
        return new ResponseEntity<>(resourceUsage, HttpStatus.CREATED);
    }

    // API to get a resource usage record by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResourceUsage> getResourceUsageById(@PathVariable Long id) {
        ResourceUsage resourceUsage = resourceUsageService.getResourceUsageById(id);
        return resourceUsage != null ? new ResponseEntity<>(resourceUsage, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get usage records for a specific resource
    @GetMapping("/resource/{resourceId}")
    public ResponseEntity<List<ResourceUsage>> getResourceUsageByResource(@PathVariable Long resourceId) {
        List<ResourceUsage> resourceUsages = resourceUsageService.getResourceUsageByResource(resourceId);
        return new ResponseEntity<>(resourceUsages, HttpStatus.OK);
    }

    // API to get usage records for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResourceUsage>> getResourceUsageByUser(@PathVariable Long userId) {
        List<ResourceUsage> resourceUsages = resourceUsageService.getResourceUsageByUser(userId);
        return new ResponseEntity<>(resourceUsages, HttpStatus.OK);
    }

    // API to get all resource usage records
    @GetMapping("/all")
    public ResponseEntity<List<ResourceUsage>> getAllResourceUsages() {
        List<ResourceUsage> resourceUsages = resourceUsageService.getAllResourceUsages();
        return new ResponseEntity<>(resourceUsages, HttpStatus.OK);
    }

    // API to update the end time of resource usage
    @PutMapping("/update/{id}")
    public ResponseEntity<ResourceUsage> updateResourceUsage(
            @PathVariable Long id,
            @RequestParam LocalDateTime endTime) {
        resourceUsageService.updateResourceUsage(id, endTime);
        ResourceUsage updatedResourceUsage = resourceUsageService.getResourceUsageById(id);
        return updatedResourceUsage != null ? new ResponseEntity<>(updatedResourceUsage, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get usage records within a specific date range
    @GetMapping("/date-range")
    public ResponseEntity<List<ResourceUsage>> getResourceUsageByDateRange(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<ResourceUsage> resourceUsages = resourceUsageService.getResourceUsageByDateRange(startDate, endDate);
        return new ResponseEntity<>(resourceUsages, HttpStatus.OK);
    }
}
