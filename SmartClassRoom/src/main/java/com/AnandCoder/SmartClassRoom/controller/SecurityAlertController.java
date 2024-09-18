package com.AnandCoder.SmartClassRoom.controller;

import com.AnandCoder.SmartClassRoom.Model.SecurityAlert;
import com.AnandCoder.SmartClassRoom.service.SecurityAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/security-alerts")
public class SecurityAlertController {

    @Autowired
    private SecurityAlertService securityAlertService;

    // API to create a new security alert
    @PostMapping
    public ResponseEntity<SecurityAlert> createSecurityAlert(@RequestBody SecurityAlert securityAlert) {
        SecurityAlert createdAlert = securityAlertService.createSecurityAlert(securityAlert);
        return new ResponseEntity<>(createdAlert, HttpStatus.CREATED);
    }

    // API to get a security alert by ID
    @GetMapping("/{id}")
    public ResponseEntity<SecurityAlert> getSecurityAlertById(@PathVariable Long id) {
        SecurityAlert alert = securityAlertService.getSecurityAlertById(id);
        return alert != null ? new ResponseEntity<>(alert, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // API to get all security alerts
    @GetMapping("/all")
    public ResponseEntity<List<SecurityAlert>> getAllSecurityAlerts() {
        List<SecurityAlert> alerts = securityAlertService.getAllSecurityAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    // API to get security alerts by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<SecurityAlert>> getAlertsByType(@PathVariable String type) {
        List<SecurityAlert> alerts = securityAlertService.getAlertsByType(type);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    // API to get security alerts by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<SecurityAlert>> getAlertsByDate(@PathVariable LocalDate date) {
        List<SecurityAlert> alerts = securityAlertService.getAlertsByDate(date);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    // API to resolve a security alert
    @PatchMapping("/{id}/resolve")
    public ResponseEntity<Void> resolveSecurityAlert(@PathVariable Long id) {
        securityAlertService.resolveSecurityAlert(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
