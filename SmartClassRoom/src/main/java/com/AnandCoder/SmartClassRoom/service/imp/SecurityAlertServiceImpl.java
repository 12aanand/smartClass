package com.AnandCoder.SmartClassRoom.service.imp;

import com.AnandCoder.SmartClassRoom.Model.SecurityAlert;
import com.AnandCoder.SmartClassRoom.repository.SecurityAlertRepository;
import com.AnandCoder.SmartClassRoom.service.SecurityAlertService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityAlertServiceImpl implements SecurityAlertService {

    @Autowired
    private SecurityAlertRepository securityAlertRepository;

    @Override
    public SecurityAlert createSecurityAlert(SecurityAlert securityAlert) {
        // Set the alert time to the current time when creating the alert
        securityAlert.setMessage(securityAlert.getMessage());
        securityAlert.setType(securityAlert.getType());
        securityAlert.setAlertTime(LocalDateTime.now());

        return securityAlertRepository.save(securityAlert);
    }

    @Override
    public SecurityAlert getSecurityAlertById(Long id) {
        // Retrieve a security alert by its ID
        Optional<SecurityAlert> alertOpt = securityAlertRepository.findById(id);
        return alertOpt.orElse(null);
    }

    @Override
    public List<SecurityAlert> getAllSecurityAlerts() {
        // Retrieve all security alerts
        return securityAlertRepository.findAll();
    }

    @Override
    public List<SecurityAlert> getAlertsByType(String type) {
        // Retrieve alerts by type (e.g., FIRE, UNAUTHORIZED_ACCESS)
        return securityAlertRepository.findByType(type);
    }

    @Override
    public List<SecurityAlert> getAlertsByDate(LocalDate date) {
        // Retrieve alerts for a specific date by comparing the alert date (ignoring time)
        return securityAlertRepository.findByAlertTimeBetween(
                date.atStartOfDay(), date.plusDays(1).atStartOfDay());
    }

    @Override
    public void resolveSecurityAlert(Long id) {
        // Since the model doesn't have a 'resolved' field, we'll update the message to indicate it has been resolved.
        Optional<SecurityAlert> alertOpt = securityAlertRepository.findById(id);
        if (alertOpt.isPresent()) {
            SecurityAlert alert = alertOpt.get();
            alert.setMessage(alert.getMessage() + " (Resolved)");
            securityAlertRepository.save(alert);
        }
    }
}



