import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> stocks; // Stock symbol -> number of shares
    private double balance;

    public Portfolio(double initialBalance) {
        this.stocks = new HashMap<>();
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost <= balance) {
            balance -= cost;
            stocks.put(stock.getSymbol(), stocks.getOrDefault(stock.getSymbol(), 0) + quantity);
        } else {
            throw new IllegalArgumentException("Insufficient balance to buy stock");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (stocks.containsKey(stock.getSymbol()) && stocks.get(stock.getSymbol()) >= quantity) {
            balance += stock.getPrice() * quantity;
            stocks.put(stock.getSymbol(), stocks.get(stock.getSymbol()) - quantity);
        } else {
            throw new IllegalArgumentException("Insufficient shares to sell");
        }
    }

    public void printPortfolio() {
        System.out.println("Portfolio Balance: " + balance);
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println("Stock: " + entry.getKey() + " | Shares: " + entry.getValue());
        }
    }
}
