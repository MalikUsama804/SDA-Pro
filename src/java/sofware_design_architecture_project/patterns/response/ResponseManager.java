package response;

public class ResponseManager {

    private ResponseStrategy strategy;

    public void setStrategy(
            ResponseStrategy strategy) {

        this.strategy = strategy;
    }

    public void executeResponse() {

        if (strategy != null) {

            strategy.executeStrategy();
        }
        else {

            System.out.println(
                    "No Response Strategy Selected."
            );
        }
    }
}