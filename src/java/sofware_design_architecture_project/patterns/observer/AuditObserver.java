package observer;

public class AuditObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println(
                "Audit Log Updated: " + message
        );
    }
}