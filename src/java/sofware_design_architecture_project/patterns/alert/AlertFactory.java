package alert;

public class AlertFactory {

    // Factory Method
    public static Alert createAlert(String alertId,
                                    String severity,
                                    String source,
                                    String timestamp,
                                    String description) {

        return new Alert(
                alertId,
                severity,
                source,
                timestamp,
                description
        );
    }

    // High Severity Alert
    public static Alert createHighAlert(String alertId,
                                        String source,
                                        String timestamp,
                                        String description) {

        return new Alert(
                alertId,
                "HIGH",
                source,
                timestamp,
                description
        );
    }

    // Medium Severity Alert
    public static Alert createMediumAlert(String alertId,
                                          String source,
                                          String timestamp,
                                          String description) {

        return new Alert(
                alertId,
                "MEDIUM",
                source,
                timestamp,
                description
        );
    }

    // Low Severity Alert
    public static Alert createLowAlert(String alertId,
                                       String source,
                                       String timestamp,
                                       String description) {

        return new Alert(
                alertId,
                "LOW",
                source,
                timestamp,
                description
        );
    }
}