public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private double totalAmount;

    public Transaction(String type, String stockSymbol,
                       int quantity, double price) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = quantity * price;
    }

    public void displayTransaction() {

        System.out.println(
            type + " | " +
            stockSymbol + " | Quantity: " +
            quantity + " | Price: ₹" +
            price + " | Total: ₹" +
            totalAmount
        );
    }
}
