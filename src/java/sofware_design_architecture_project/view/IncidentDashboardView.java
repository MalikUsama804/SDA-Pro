package com.mycompany.sda_project.view;

public class IncidentDashboardView {
    // Standard view output display loop logic
    public void displayIncidentDetails(String id, String status) {
        System.out.println("\n==================================================");
        System.out.println("       ANALYST REAL-TIME SOC DASHBOARD (MVC)      ");
        System.out.println("==================================================");
        System.out.println("  Active Track ID : " + id);
        System.out.println("  Operational Status: " + status);
        System.out.println("==================================================\n");
    }
}