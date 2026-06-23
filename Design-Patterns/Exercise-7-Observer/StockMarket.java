import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.price = initialPrice;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer registered: " + observer.getClass().getSimpleName());
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer deregistered: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        System.out.println("\nNotifying all observers about " + stockName + " price change...");
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    // Method to update stock price
    public void setPrice(double newPrice) {
        System.out.println("\n=== Stock Update ===");
        System.out.println(stockName + " price changed from $" + price + " to $" + newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }
}
