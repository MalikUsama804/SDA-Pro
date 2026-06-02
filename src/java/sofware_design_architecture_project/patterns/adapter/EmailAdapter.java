package adapter;

public class EmailAdapter {

    public void sendEmail(
            String message) {

        System.out.println(
                "Email Sent: "
                        + message
        );
    }
}