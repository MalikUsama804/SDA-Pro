package decorator;

public class LoggingDecorator extends ResponseDecorator {

    @Override
    public void execute() {

        System.out.println(
                "Adding Logging Support..."
        );
    }
}