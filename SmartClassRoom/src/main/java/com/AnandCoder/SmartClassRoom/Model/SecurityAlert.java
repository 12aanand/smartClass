package com.AnandCoder.SmartClassRoom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SecurityAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type; // e.g., "FIRE", "UNAUTHORIZED_ACCESS"
    private String message;
    private LocalDateTime alertTime;

    public SecurityAlert()
    {

    }

    public SecurityAlert(Long id, String type, String message, LocalDateTime alertTime) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.alertTime = alertTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(LocalDateTime alertTime) {
        this.alertTime = alertTime;
    }
}
