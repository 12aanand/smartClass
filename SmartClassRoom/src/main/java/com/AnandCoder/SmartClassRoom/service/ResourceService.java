package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.Resource;

import java.util.List;

public interface ResourceService {
    Resource addResource(Resource resource); // Add a new resource

    Resource getResourceById(Long id); // Retrieve a resource by ID

    List<Resource> getAllResources(); // Retrieve all resources

    Resource updateResource(Long id, Resource resource); // Update an existing resource

    void deleteResource(Long id); // Delete a resource by ID

    List<Resource> getAvailableResources(); // Retrieve all available resources

    List<Resource> getResourcesByType(String type); // Retrieve resources by type (e.g., projector, computer)

}
