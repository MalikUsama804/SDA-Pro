package com.mycompany.sda_project.model;

import java.util.ArrayList;
import java.util.List;

// PATTERN: Composite Container Node
public class AlertCampaign implements AlertComponent {
    private String campaignName;
    private List<AlertComponent> children; // Stores both individual alerts and sub-campaigns

    public AlertCampaign(String campaignName) {
        this.campaignName = campaignName;
        this.children = new ArrayList<>();
    }

    public void addAlert(AlertComponent component) {
        children.add(component);
    }

    public void removeAlert(AlertComponent component) {
        children.remove(component);
    }

    @Override
    public void printDetails() {
        System.out.println("[Composite Campaign] Name: " + campaignName);
        for (AlertComponent child : children) {
            child.printDetails(); // Recursively prints leaf nodes or sub-campaigns
        }
    }

    @Override
    public String getSeverity() {
        // Simple logic: if any child is CRITICAL, the campaign is CRITICAL
        for (AlertComponent child : children) {
            if ("CRITICAL".equalsIgnoreCase(child.getSeverity())) {
                return "CRITICAL";
            }
        }
        return "MEDIUM";
    }
}