package response;

public class ResponseAction {

    private String actionId;
    private String actionType;

    public ResponseAction(
            String actionId,
            String actionType) {

        this.actionId = actionId;
        this.actionType = actionType;
    }

    public void execute() {

        System.out.println(
                "Executing Action: "
                        + actionType
        );
    }

    public void rollback() {

        System.out.println(
                "Rolling Back Action: "
                        + actionType
        );
    }

    public String getActionId() {

        return actionId;
    }

    public String getActionType() {

        return actionType;
    }
}