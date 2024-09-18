package com.AnandCoder.SmartClassRoom.service.imp;

import com.AnandCoder.SmartClassRoom.Model.Resource;
import com.AnandCoder.SmartClassRoom.repository.ResourceRepository;
import com.AnandCoder.SmartClassRoom.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource addResource(Resource resource) {
        // Add a new resource to the database
        return resourceRepository.save(resource);
    }

    @Override
    public Resource getResourceById(Long id) {
        // Retrieve a resource by its ID
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        return resourceOpt.orElse(null); // Return the resource or null if not found
    }

    @Override
    public List<Resource> getAllResources() {
        // Retrieve all resources from the database
        return resourceRepository.findAll();
    }

    @Override
    public Resource updateResource(Long id, Resource resourceDetails) {
        // Retrieve the resource to be updated
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        if (resourceOpt.isPresent()) {
            Resource existingResource = resourceOpt.get();
            // Update the resource's details
            existingResource.setName(resourceDetails.getName());
            existingResource.setType(resourceDetails.getType());
            existingResource.setStatus(resourceDetails.getStatus());
            existingResource.setLastMaintenanceDate(resourceDetails.getLastMaintenanceDate());
            existingResource.setNextMaintenanceDate(resourceDetails.getNextMaintenanceDate());
            // Save the updated resource to the database
            return resourceRepository.save(existingResource);
        }
        return null; // Return null if resource is not found
    }

    @Override
    public void deleteResource(Long id) {
        // Delete the resource by its ID
        resourceRepository.deleteById(id);
    }

    @Override
    public List<Resource> getResourcesByType(String type) {
        // Retrieve resources by their type (e.g., "Projector", "Computer")
        return resourceRepository.findByType(type);
    }

    @Override
    public List<Resource> getAvailableResources() {
        // Retrieve resources that are currently available (not in use)
        return resourceRepository.findByStatus("Available");
    }
}
