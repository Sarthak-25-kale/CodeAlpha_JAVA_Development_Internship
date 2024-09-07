import java.util.Scanner;

public class TradingPlatform {
    private Portfolio portfolio;
    private MarketData marketData;

    public TradingPlatform(double initialBalance) {
        portfolio = new Portfolio(initialBalance);
        marketData = new MarketData();
    }

    public void startTrading() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Stock Trading Platform");
            System.out.println("1. View Portfolio");
            System.out.println("2. View Market Data");
            System.out.println("3. Buy Stock");
            System.out.println("4. Sell Stock");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    portfolio.printPortfolio();
                    break;
                case 2:
                    viewMarketData();
                    break;
                case 3:
                    buyStock(scanner);
                    break;
                case 4:
                    sellStock(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void viewMarketData() {
        System.out.println("Market Data:");
        System.out.println(marketData.getStock("AAPL"));
        System.out.println(marketData.getStock("GOOGL"));
        System.out.println(marketData.getStock("AMZN"));
    }

    private void buyStock(Scanner scanner) {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.next().toUpperCase();
        Stock stock = marketData.getStock(symbol);
        if (stock == null) {
            System.out.println("Stock not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        try {
            portfolio.buyStock(stock, quantity);
            System.out.println("Stock purchased successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void sellStock(Scanner scanner) {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.next().toUpperCase();
        Stock stock = marketData.getStock(symbol);
        if (stock == null) {
            System.out.println("Stock not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        try {
            portfolio.sellStock(stock, quantity);
            System.out.println("Stock sold successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        TradingPlatform platform = new TradingPlatform(10000.00); // Starting balance
        platform.startTrading();
    }
}
