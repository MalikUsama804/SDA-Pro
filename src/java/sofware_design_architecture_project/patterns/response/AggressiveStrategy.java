package response;

public class AggressiveStrategy implements ResponseStrategy {

    @Override
    public void executeStrategy() {

        System.out.println(
                "Executing Aggressive Response Strategy..."
        );

        System.out.println(
                "Blocking IP Address..."
        );

        System.out.println(
                "Isolating Endpoint..."
        );
    }
}