package com.AnandCoder.SmartClassRoom.service.imp;



import com.AnandCoder.SmartClassRoom.Model.Resource;
import com.AnandCoder.SmartClassRoom.Model.ResourceUsage;
import com.AnandCoder.SmartClassRoom.Model.User;
import com.AnandCoder.SmartClassRoom.repository.ResourceRepository;
import com.AnandCoder.SmartClassRoom.repository.ResourceUsageRepository;
import com.AnandCoder.SmartClassRoom.repository.UserRepository;
import com.AnandCoder.SmartClassRoom.service.ResourceUsageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ResourceUsageServiceImpl implements ResourceUsageService {

    @Autowired
    private ResourceUsageRepository resourceUsageRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResourceUsage trackResourceUsage(Long resourceId, Long userId,LocalDateTime startTime) {
        // Track resource usage
        Optional<Resource> resourceOpt = resourceRepository.findById(resourceId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (resourceOpt.isPresent() && userOpt.isPresent()) {
            ResourceUsage resourceUsage = new ResourceUsage();
            resourceUsage.setResource(resourceOpt.get());
            resourceUsage.setUser(userOpt.get());
            resourceUsage.setStartTime(startTime);

            return resourceUsageRepository.save(resourceUsage);
        }
        return null;
    }

    @Override
    public ResourceUsage getResourceUsageById(Long id) {
        // Retrieve a resource usage record by ID
        Optional<ResourceUsage> usageOpt = resourceUsageRepository.findById(id);
        return usageOpt.orElse(null);
    }

    @Override
    public List<ResourceUsage> getResourceUsageByResource(Long resourceId) {
        // Retrieve usage records for a specific resource
        return resourceUsageRepository.findByResourceId(resourceId);
    }

    @Override
    public List<ResourceUsage> getResourceUsageByUser(Long userId) {
        // Retrieve usage records for a specific user
        return resourceUsageRepository.findByUserId(userId);
    }

    @Override
    public List<ResourceUsage> getAllResourceUsages() {
        // Retrieve all resource usage records
        return resourceUsageRepository.findAll();
    }

    @Override
    public void updateResourceUsage(Long id, LocalDateTime endTime) {
        // Update the end time of resource usage
        Optional<ResourceUsage> usageOpt = resourceUsageRepository.findById(id);
        if (usageOpt.isPresent()) {
            ResourceUsage existingUsage = usageOpt.get();
            existingUsage.setEndTime(endTime);
            resourceUsageRepository.save(existingUsage);
        }
    }

    @Override
    public List<ResourceUsage> getResourceUsageByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        // Retrieve usage records within a specific date range
        return resourceUsageRepository.findByStartTimeBetween(startDate, endDate);
    }
}

