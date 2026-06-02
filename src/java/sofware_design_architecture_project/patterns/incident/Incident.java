package incident;

public class Incident {

    private String incidentId;
    private String severity;
    private String status;

    private IncidentState currentState;

    public Incident(String incidentId,
                    String severity,
                    String status) {

        this.incidentId = incidentId;
        this.severity = severity;
        this.status = status;

        this.currentState = new NewState();
    }

    public void setState(IncidentState state) {

        this.currentState = state;
    }

    public void handleIncident() {

        currentState.handle();
    }

    public void createIncident() {

        System.out.println(
                "Incident Created: " + incidentId
        );
    }

    public void closeIncident() {

        System.out.println(
                "Incident Closed: " + incidentId
        );

        currentState = new ClosedState();
    }

    public String getIncidentId() {

        return incidentId;
    }

    public String getSeverity() {

        return severity;
    }

    public String getStatus() {

        return status;
    }
}