public class StrategyPatternExample {
    public interface PaymentStrategy {
        void pay(int amount);
    }
    // Concrete implementation for CreditCardPayment
    public class CreditCardPayment implements PaymentStrategy {
        private String userName;
        private String cardNumber;
        public CreditCardPayment(String uname, String cno) {
            this.userName = uname;
            this.cardNumber = cno;
        }
        @Override
        public void pay(int amount) {
            System.out.println("The amount " + amount + " was paid successfully by " + userName + " using Credit Card.");
        }
    }
    // Concrete implementation for PayPalPayment
    public class PayPalPayment implements PaymentStrategy {
        private String userName;
        private String upiId;
        private String phone;
        public PayPalPayment(String uname, String id, String no) {
            this.userName = uname;
            this.upiId = id;
            this.phone = no;
        }
        @Override
        public void pay(int amount) {
            System.out.println("The amount " + amount + " was paid successfully by " + userName + " using PayPal.");
        }
    }

    // PaymentContext class
    public class PaymentContext {
        private PaymentStrategy paymentStrategy;
        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }
        public void executeStrategy(int amount) {
            paymentStrategy.pay(amount);
        }
    }
    
    public static void main(String[] args) {
        StrategyPatternExample example = new StrategyPatternExample();
        
        // Create a payment strategy
        PaymentStrategy payment1 = example.new CreditCardPayment("Swetha", "9444688163");
        PaymentStrategy payment2 = example.new PayPalPayment("Jason","jason@gmail.com","9488825093");

        // Create a payment context with the strategy
        PaymentContext pay1 = example.new PaymentContext(payment1);
        PaymentContext pay2 = example.new PaymentContext(payment2);

        // Execute the payment strategy
        pay1.executeStrategy(1000);
        pay2.executeStrategy(2000);
    }
}
