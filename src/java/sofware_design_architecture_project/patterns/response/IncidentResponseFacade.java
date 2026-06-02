package response;

public class IncidentResponseFacade {

    private ResponseManager responseManager;

    public IncidentResponseFacade() {

        responseManager =
                new ResponseManager();
    }

    public void handleIncidentResponse() {

        System.out.println(
                "\n=== Incident Response Started ==="
        );

        responseManager.setStrategy(
                new AggressiveStrategy()
        );

        responseManager.executeResponse();

        System.out.println(
                "=== Incident Response Completed ==="
        );
    }
}