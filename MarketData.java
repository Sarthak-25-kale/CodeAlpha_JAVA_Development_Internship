import java.util.HashMap;
import java.util.Map;

public class MarketData {
    private Map<String, Stock> marketStocks;

    public MarketData() {
        marketStocks = new HashMap<>();
        loadMarketData();
    }

    private void loadMarketData() {
        // Simulate market data
        marketStocks.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.00));
        marketStocks.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        marketStocks.put("AMZN", new Stock("AMZN", "Amazon.com, Inc.", 3500.00));
    }

    public Stock getStock(String symbol) {
        return marketStocks.get(symbol);
    }

    public void updatePrice(String symbol, double newPrice) {
        Stock stock = marketStocks.get(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        }
    }
}
