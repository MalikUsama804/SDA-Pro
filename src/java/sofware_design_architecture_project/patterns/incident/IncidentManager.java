package incident;

import java.util.ArrayList;
import java.util.List;

public class IncidentManager {

    private List<Incident> incidents;

    public IncidentManager() {
        incidents = new ArrayList<>();
    }

    public void addIncident(Incident incident) {

        if (incident != null) {

            incidents.add(incident);

            System.out.println(
                    "Incident Added: "
                            + incident.getIncidentId()
            );
        } else {

            System.out.println("Invalid Incident.");
        }
    }

    public void removeIncident(String incidentId) {

        Incident incident = findIncidentById(incidentId);

        if (incident != null) {

            incidents.remove(incident);

            System.out.println(
                    "Incident Removed: "
                            + incident.getIncidentId()
            );

        } else {

            System.out.println("Incident Not Found.");
        }
    }

    public Incident findIncidentById(String incidentId) {

        for (Incident incident : incidents) {

            if (incident.getIncidentId()
                    .equalsIgnoreCase(incidentId)) {

                return incident;
            }
        }

        return null;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public int getTotalIncidents() {
        return incidents.size();
    }

    public void displayIncidents() {

        if (incidents.isEmpty()) {

            System.out.println("No Incidents Found.");
            return;
        }

        System.out.println("\n===== INCIDENT LIST =====");

        for (Incident incident : incidents) {

            System.out.println(
                    "ID: "
                            + incident.getIncidentId()
            );

            System.out.println(
                    "Severity: "
                            + incident.getSeverity()
            );

            System.out.println(
                    "Status: "
                            + incident.getStatus()
            );

            System.out.println("----------------------");
        }
    }
}