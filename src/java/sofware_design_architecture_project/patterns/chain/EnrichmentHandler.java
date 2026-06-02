package chain;

public class EnrichmentHandler extends Handler {

    @Override
    public void handleRequest(
            String request) {

        System.out.println(
                "Enriching Alert..."
        );

        if (nextHandler != null) {

            nextHandler.handleRequest(
                    request
            );
        }
    }
}