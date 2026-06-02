package decorator;

public class AuditDecorator extends ResponseDecorator {

    @Override
    public void execute() {

        System.out.println(
                "Adding Audit Logging..."
        );
    }
}