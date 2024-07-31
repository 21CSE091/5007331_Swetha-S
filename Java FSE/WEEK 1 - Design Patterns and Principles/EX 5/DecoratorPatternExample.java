interface Notifier {
    void send();
}
class EmailNotifier implements Notifier {
    private String email;
    private String username;
    public EmailNotifier(String email, String username) {
        this.email = email;
        this.username = username;
    }
    @Override 
    public void send() {
        System.out.println("An email notification has been sent to user " + username + " at " + email + "!");
    }
}
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    @Override
    public void send() {
        notifier.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    private String username;
    private String phone;
    public SMSNotifierDecorator(Notifier notifier, String username, String phone) {
        super(notifier);
        this.username = username;
        this.phone = phone;
    }
    @Override
    public void send() {
        super.send();
        System.out.println("The SMS was sent to the user " + username + " at phone number " + phone + "!");
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    private String username;
    private String userId;
    public SlackNotifierDecorator(Notifier notifier, String username, String userId) {
        super(notifier);
        this.username = username;
        this.userId = userId;
    }
    @Override
    public void send() {
        super.send();
        System.out.println("User ID " + userId + " received a Slack notification!");
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier("swetha@gmail.com", "Swetha");

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier, "Swetha", "9444688163");

        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier, "Swetha", "swetha_67");

        System.out.println("EMAIL NOTIFIER:");
        emailNotifier.send();

        System.out.println("\nEMAIL AND SMS NOTIFIER:");
        smsNotifier.send();

        System.out.println("\nEMAIL AND SLACK NOTIFIER:");
        slackNotifier.send();
    }   
}