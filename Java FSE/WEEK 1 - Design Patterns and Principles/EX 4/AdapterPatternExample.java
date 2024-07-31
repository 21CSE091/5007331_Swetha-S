interface PaymentProcessor {
    void processPayment(int amount);
}

class UPISystem {
    private String upiId;
    private String username;
    private String phoneNumber;
    public UPISystem(String upiId, String username, String phoneNumber) {
        this.upiId = upiId;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public void performUPIPayment(int amount) {
        System.out.println("Processing UPI Payment");
        System.out.println("Username: " + username);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Amount paid: " + amount);
        System.out.println();
    }
}

class PayPalSystem {
    private String email;
    private String username;
    public PayPalSystem(String email, String username) {
        this.email = email;
        this.username = username;
    }
    public void performPayPalPayment(int amount) {
        System.out.println("Processing PayPal Payment");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Amount paid: " + amount);
        System.out.println();
    }
}

class CreditCardSystem {
    private String cardNumber;
    private String cardHolder;
    public CreditCardSystem(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }
    public void performCreditCardPayment(int amount) {
        System.out.println("Processing Credit Card Payment");
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount paid: " + amount);
        System.out.println();
    }
}

class UPIPaymentAdapter implements PaymentProcessor {
    private UPISystem upiSystem;
    public UPIPaymentAdapter(UPISystem upiSystem) {
        this.upiSystem = upiSystem;
    }
    @Override
    public void processPayment(int amount) {
        upiSystem.performUPIPayment(amount);
    }
}

class PayPalPaymentAdapter implements PaymentProcessor {
    private PayPalSystem payPalSystem;
    public PayPalPaymentAdapter(PayPalSystem payPalSystem) {
        this.payPalSystem = payPalSystem;
    }
    @Override
    public void processPayment(int amount) {
        payPalSystem.performPayPalPayment(amount);
    }
}

class CreditCardPaymentAdapter implements PaymentProcessor {
    private CreditCardSystem creditCardSystem;
    public CreditCardPaymentAdapter(CreditCardSystem creditCardSystem) {
        this.creditCardSystem = creditCardSystem;
    }
    @Override
    public void processPayment(int amount) {
        creditCardSystem.performCreditCardPayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        
        UPISystem upiSystem = new UPISystem("swetha@oksbi", "Swetha", "9444688163");
        PaymentProcessor upiPayment = new UPIPaymentAdapter(upiSystem);
        
        PayPalSystem payPalSystem = new PayPalSystem("abitha@okiob", "Abitha");
        PaymentProcessor payPalPayment = new PayPalPaymentAdapter(payPalSystem);

        CreditCardSystem creditCardSystem = new CreditCardSystem("1234-5678-1234-5678", "Tharika");
        PaymentProcessor creditCardPayment = new CreditCardPaymentAdapter(creditCardSystem);

        upiPayment.processPayment(10000);

        payPalPayment.processPayment(20000);

        creditCardPayment.processPayment(30000);
    }
}