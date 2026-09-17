import java.util.HashMap;

public class Portfolio {

    private double cash;
    private HashMap<String, Integer> holdings;

    public Portfolio(double cash) {
        this.cash = cash;
        holdings = new HashMap<>();
    }

    // Buy stock
    public void buyStock(Stock stock, int quantity) {

        double totalCost = stock.getPrice() * quantity;

        if (totalCost > cash) {
            System.out.println("Insufficient balance!");
            return;
        }

        cash = cash - totalCost;

        int oldQuantity =
                holdings.getOrDefault(stock.getSymbol(), 0);

        holdings.put(
                stock.getSymbol(),
                oldQuantity + quantity
        );

        System.out.println(
                "Successfully bought " +
                quantity + " shares of " +
                stock.getSymbol()
        );
    }

    // Sell stock
    public void sellStock(Stock stock, int quantity) {

        int available =
                holdings.getOrDefault(stock.getSymbol(), 0);

        if (available < quantity) {
            System.out.println("Not enough shares to sell!");
            return;
        }

        double totalAmount = stock.getPrice() * quantity;

        cash = cash + totalAmount;

        holdings.put(
                stock.getSymbol(),
                available - quantity
        );

        System.out.println(
                "Successfully sold " +
                quantity + " shares of " +
                stock.getSymbol()
        );
    }

    public void displayPortfolio() {

        System.out.println("\n========== PORTFOLIO ==========");

        System.out.println("Cash Balance: ₹" + cash);

        System.out.println("\nStock Holdings:");

        if (holdings.isEmpty()) {
            System.out.println("No stocks owned.");
        } else {

            for (String symbol : holdings.keySet()) {

                System.out.println(
                        symbol + " : " +
                        holdings.get(symbol) +
                        " shares"
                );
            }
        }

        System.out.println("===============================");
    }

    public double getCash() {
        return cash;
    }
}
