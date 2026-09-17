import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample market stocks
        Stock apple =
                new Stock("AAPL", "Apple", 180);

        Stock google =
                new Stock("GOOG", "Google", 150);

        Stock tesla =
                new Stock("TSLA", "Tesla", 250);

        // Create user
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        User user = new User(name, 10000);

        int choice;

        do {

            System.out.println("\n========== STOCK TRADING PLATFORM ==========");

            System.out.println("1. Display Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n---------- MARKET DATA ----------");

                    apple.displayStock();
                    google.displayStock();
                    tesla.displayStock();

                    break;

                case 2:

                    System.out.println("\nSelect Stock:");

                    System.out.println("1. Apple (AAPL)");
                    System.out.println("2. Google (GOOG)");
                    System.out.println("3. Tesla (TSLA)");

                    System.out.print("Enter stock choice: ");
                    int buyChoice = sc.nextInt();

                    Stock buyStock = null;

                    if (buyChoice == 1) {
                        buyStock = apple;
                    } else if (buyChoice == 2) {
                        buyStock = google;
                    } else if (buyChoice == 3) {
                        buyStock = tesla;
                    } else {
                        System.out.println("Invalid stock choice!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int buyQuantity = sc.nextInt();

                    user.getPortfolio()
                            .buyStock(buyStock, buyQuantity);

                    break;

                case 3:

                    System.out.println("\nSelect Stock:");

                    System.out.println("1. Apple (AAPL)");
                    System.out.println("2. Google (GOOG)");
                    System.out.println("3. Tesla (TSLA)");

                    System.out.print("Enter stock choice: ");
                    int sellChoice = sc.nextInt();

                    Stock sellStock = null;

                    if (sellChoice == 1) {
                        sellStock = apple;
                    } else if (sellChoice == 2) {
                        sellStock = google;
                    } else if (sellChoice == 3) {
                        sellStock = tesla;
                    } else {
                        System.out.println("Invalid stock choice!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int sellQuantity = sc.nextInt();

                    user.getPortfolio()
                            .sellStock(sellStock, sellQuantity);

                    break;

                case 4:

                    user.displayUser();

                    break;

                case 5:

                    System.out.println(
                            "\nThank you for using Stock Trading Platform!"
                    );

                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

        sc.close();
    }
}
