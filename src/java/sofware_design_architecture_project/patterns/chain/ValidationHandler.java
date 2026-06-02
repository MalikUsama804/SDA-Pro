package chain;

public class ValidationHandler extends Handler {

    @Override
    public void handleRequest(
            String request) {

        System.out.println(
                "Validating Alert..."
        );

        if (nextHandler != null) {

            nextHandler.handleRequest(
                    request
            );
        }
    }
}