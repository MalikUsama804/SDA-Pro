package incident;

public class ClosedState implements IncidentState {

    @Override
    public void handle() {
        System.out.println("Incident is in CLOSED state.");
    }
}