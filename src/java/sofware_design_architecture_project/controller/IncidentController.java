package com.mycompany.sda_project.controller;

import com.mycompany.sda_project.model.IncidentModel;
import com.mycompany.sda_project.view.IncidentDashboardView;

public class IncidentController {
    private IncidentModel model;
    private IncidentDashboardView view;

    public IncidentController(IncidentModel model, IncidentDashboardView view) {
        this.model = model;
        this.view = view;
    }

    public void updateIncidentStatus(String status) {
        model.setStatus(status);
    }

    // Directs the view components to re-render layout data fields
    public void refreshDashboard() {
        view.displayIncidentDetails(model.getIncidentId(), model.getStatus());
    }
}