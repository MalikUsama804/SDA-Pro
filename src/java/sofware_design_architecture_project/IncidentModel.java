package com.mycompany.sda_project.model;

public class IncidentModel {
    private String incidentId;
    private String status;

    public IncidentModel(String incidentId, String status) {
        this.incidentId = incidentId;
        this.status = status;
    }

    public String getIncidentId() { return incidentId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}