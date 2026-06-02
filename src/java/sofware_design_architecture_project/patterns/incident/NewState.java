package incident;

public class NewState implements IncidentState {

    @Override
    public void handle() {
        System.out.println("Incident is in NEW state.");
    }
}