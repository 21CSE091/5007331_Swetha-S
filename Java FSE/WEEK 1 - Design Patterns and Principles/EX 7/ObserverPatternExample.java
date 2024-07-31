import java.util.*;

public class ObserverPatternExample {

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        
        Observer webApp1 = new WebApp("Swetha", "swetha@gmail.com", "9444688163", stockMarket);
        Observer webApp2 = new WebApp("Tharika", "tharika@gmail.com", "8825900351", stockMarket);
        Observer mobileApp = new MobileApp("Subi", "subi@gmail.com", "9488815520", stockMarket);
        
        stockMarket.register(webApp1);
        stockMarket.register(webApp2);
        stockMarket.register(mobileApp);
        
        stockMarket.notifyObservers();
    }
}

interface Stock {
    void register(Observer obs);
    void deregister(Observer obs);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

interface Observer {
    void update();
}

class MobileApp implements Observer {
    private String username;
    private String email;
    private String phone;
    private StockMarket stockMarket;
    
    public MobileApp(String username, String email, String phone, StockMarket stockMarket) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.stockMarket = stockMarket;
    }
    
    @Override
    public void update() {
        System.out.println(username + ", you received a new notification! Check the stock price changes. (Mobile App)");
    }
}

class WebApp implements Observer {
    private String username;
    private String email;
    private String phone;
    private StockMarket stockMarket;
    
    public WebApp(String username, String email, String phone, StockMarket stockMarket) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.stockMarket = stockMarket;
    }
    
    @Override
    public void update() {
        System.out.println(username + ", you received a new notification! Check the stock price changes. (Web App)");
    }
}