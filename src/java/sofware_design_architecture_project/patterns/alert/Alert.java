package alert;

public class Alert {

    private String alertId;
    private String severity;
    private String source;
    private String timestamp;
    private String description;

    public Alert(String alertId, String severity, String source,
                 String timestamp, String description) {

        this.alertId = alertId;
        this.severity = severity;
        this.source = source;
        this.timestamp = timestamp;
        this.description = description;
    }

    public void normalizeAlert() {
        System.out.println("Normalizing Alert: " + alertId);
    }

    public void enrichAlert() {
        System.out.println("Enriching Alert: " + alertId);
    }

    public void displayAlert() {
        System.out.println("Alert ID: " + alertId);
        System.out.println("Severity: " + severity);
        System.out.println("Source: " + source);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Description: " + description);
    }

    public String getAlertId() {
        return alertId;
    }

    public String getSeverity() {
        return severity;
    }

    public String getSource() {
        return source;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }
}