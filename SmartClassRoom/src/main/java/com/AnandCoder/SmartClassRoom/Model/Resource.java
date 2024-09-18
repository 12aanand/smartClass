package com.AnandCoder.SmartClassRoom.Model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type; // E.g., "Projector", "Computer"

    @Column(nullable = false)
    private String status; // E.g., "Available", "In Use", "Under Maintenance"

    private LocalDate lastMaintenanceDate;

    private LocalDate nextMaintenanceDate;

    public Resource()
    {

    }

    public Resource(Long id, String name, String type, String status, LocalDate lastMaintenanceDate, LocalDate nextMaintenanceDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public LocalDate getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public void setNextMaintenanceDate(LocalDate nextMaintenanceDate) {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }
}
