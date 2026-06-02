package alert;

import java.util.ArrayList;
import java.util.List;

public class AlertCampaign {

    private String campaignId;
    private String campaignName;
    private List<Alert> alerts;

    public AlertCampaign(String campaignId, String campaignName) {
        this.campaignId = campaignId;
        this.campaignName = campaignName;
        this.alerts = new ArrayList<>();
    }

    public void addAlert(Alert alert) {
        alerts.add(alert);
        System.out.println("Alert added to campaign.");
    }

    public void removeAlert(Alert alert) {
        alerts.remove(alert);
        System.out.println("Alert removed from campaign.");
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void displayCampaign() {
        System.out.println("Campaign ID: " + campaignId);
        System.out.println("Campaign Name: " + campaignName);
        System.out.println("Total Alerts: " + alerts.size());
    }
}