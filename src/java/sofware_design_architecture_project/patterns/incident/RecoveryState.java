package incident;

public class RecoveryState implements IncidentState {

    @Override
    public void handle() {
        System.out.println("Incident is in RECOVERY state.");
    }
}