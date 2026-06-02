package response;

public class ConservativeStrategy implements ResponseStrategy {

    @Override
    public void executeStrategy() {

        System.out.println(
                "Executing Conservative Response Strategy..."
        );

        System.out.println(
                "Monitoring Suspicious Activity..."
        );
    }
}