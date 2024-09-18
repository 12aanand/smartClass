package com.AnandCoder.SmartClassRoom.controller;


import com.AnandCoder.SmartClassRoom.Model.Resource;
import com.AnandCoder.SmartClassRoom.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    // API to add a new resource
    @PostMapping("/add")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.addResource(resource);
        return new ResponseEntity<>(createdResource, HttpStatus.CREATED);
    }

    // API to get a resource by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = resourceService.getResourceById(id);
        return resource != null ? new ResponseEntity<>(resource, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get all resources
    @GetMapping("/all")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    // API to update a resource
    @PutMapping("/update/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resourceDetails) {
        Resource updatedResource = resourceService.updateResource(id, resourceDetails);
        return updatedResource != null ? new ResponseEntity<>(updatedResource, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to delete a resource
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // API to get all available resources
    @GetMapping("/available")
    public ResponseEntity<List<Resource>> getAvailableResources() {
        List<Resource> availableResources = resourceService.getAvailableResources();
        return new ResponseEntity<>(availableResources, HttpStatus.OK);
    }

    // API to get resources by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Resource>> getResourcesByType(@PathVariable String type) {
        List<Resource> resourcesByType = resourceService.getResourcesByType(type);
        return new ResponseEntity<>(resourcesByType, HttpStatus.OK);
    }
}
