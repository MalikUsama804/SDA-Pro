package alert;

import java.util.ArrayList;
import java.util.List;

public class AlertManager {

    private List<Alert> alerts;

    public AlertManager() {
        alerts = new ArrayList<>();
    }

    public void addAlert(Alert alert) {

        if (alert != null) {
            alerts.add(alert);
            System.out.println("Alert Added Successfully.");
        } else {
            System.out.println("Invalid Alert.");
        }
    }

    public void removeAlert(String alertId) {

        Alert alert = findAlertById(alertId);

        if (alert != null) {
            alerts.remove(alert);
            System.out.println("Alert Removed Successfully.");
        } else {
            System.out.println("Alert Not Found.");
        }
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public Alert findAlertById(String alertId) {

        for (Alert alert : alerts) {

            if (alert.getAlertId().equalsIgnoreCase(alertId)) {
                return alert;
            }
        }

        return null;
    }

    public void displayAllAlerts() {

        if (alerts.isEmpty()) {
            System.out.println("No Alerts Available.");
            return;
        }

        System.out.println("\n===== ALERT LIST =====");

        for (Alert alert : alerts) {

            alert.displayAlert();
            System.out.println("------------------------");
        }
    }

    public int getTotalAlerts() {
        return alerts.size();
    }
}