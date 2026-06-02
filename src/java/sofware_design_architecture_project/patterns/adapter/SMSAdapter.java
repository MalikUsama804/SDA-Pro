package adapter;

public class SMSAdapter {

    public void sendSMS(
            String message) {

        System.out.println(
                "SMS Sent: "
                        + message
        );
    }
}