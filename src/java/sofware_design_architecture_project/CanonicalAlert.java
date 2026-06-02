package com.mycompany.sda_project.model;

// This acts as the "Leaf" node in the Composite pattern
public class CanonicalAlert implements AlertComponent {
    private String alertId;
    private String source; 
    private String ipAddress;
    private String severity; 
    private String description;

    public CanonicalAlert(String alertId, String source, String ipAddress, String severity, String description) {
        this.alertId = alertId;
        this.source = source;
        this.ipAddress = ipAddress;
        this.severity = severity;
        this.description = description;
    }

    @Override
    public void printDetails() {
        System.out.println("  -> [Leaf Alert] ID: " + alertId + " | Source: " + source + " | Severity: " + severity);
    }

    @Override
    public String getSeverity() { return this.severity; }
    public String getAlertId() { return alertId; }
    public String getSource() { return source; }
    public String getIpAddress() { return ipAddress; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "CanonicalAlert [" + source + " | Severity: " + severity + " | IP: " + ipAddress + "]";
    }
}