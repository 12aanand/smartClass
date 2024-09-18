package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.SecurityAlert;

import java.time.LocalDate;
import java.util.List;

public interface SecurityAlertService {

    SecurityAlert createSecurityAlert(SecurityAlert securityAlert); // Create a new security alert

    SecurityAlert getSecurityAlertById(Long id); // Retrieve a security alert by ID

    List<SecurityAlert> getAllSecurityAlerts(); // Retrieve all security alerts

    List<SecurityAlert> getAlertsByType(String type); // Retrieve alerts by type (e.g., FIRE, UNAUTHORIZED_ACCESS)

    List<SecurityAlert> getAlertsByDate(LocalDate date); // Retrieve alerts for a specific date

    void resolveSecurityAlert(Long id); // Mark a security alert as resolved
}

