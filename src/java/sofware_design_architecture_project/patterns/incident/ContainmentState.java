package incident;

public class ContainmentState implements IncidentState {

    @Override
    public void handle() {
        System.out.println("Incident is in CONTAINMENT state.");
    }
}