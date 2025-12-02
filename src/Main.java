import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    // StockManager instance with a generic type constraint (IStockable)
    private static StockManager<IStockable> manager = new StockManager<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Basic Stock Tracking System!");
        seedData(); // Populate initial data

        int choice = -1;
        while (choice != 0) {
            displayMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                executeChoice(choice);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        System.out.println("Thank you for using the system. Goodbye!");
    }

    // Example of adding initial data (using polymorphism)
    private static void seedData() {
        // Book and ElectronicItem objects are treated as IStockable (Polymorphism)
        manager.addItem(new Book("The Great Gatsby", 15.99, 50, "F. Scott Fitzgerald"));
        manager.addItem(new ElectronicItem("Wireless Mouse", 25.50, 100, 24));
        manager.addItem(new Book("1984", 10.00, 30, "George Orwell"));
        manager.addItem(new ElectronicItem("4K Monitor", 399.99, 15, 36));
    }

    private static void displayMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. List All Items");
        System.out.println("2. Update Stock");
        System.out.println("3. Find Items by Price Range (Lambda Demo)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                manager.listAllItems();
                break;
            case 2:
                updateStockUI();
                break;
            case 3:
                findItemsByPriceRangeUI();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void updateStockUI() {
        System.out.print("Enter the name of the item to update stock: ");
        String name = scanner.nextLine();
        // Item is retrieved as IStockable (Polymorphism)
        IStockable item = manager.findItemByName(name);

        if (item != null) {
            System.out.print("Enter the amount to update (+ for add, - for subtract): ");
            if (scanner.hasNextInt()) {
                int amount = scanner.nextInt();
                scanner.nextLine();
                item.updateStock(amount); // Polymorphism: The correct updateStock() is called
                System.out.println("Stock updated successfully. New stock: " + item.getStock());
            } else {
                System.out.println("Invalid amount input.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void findItemsByPriceRangeUI() {
        System.out.print("Enter minimum price: $");

        // minPrice ve maxPrice'ı final yapabilmek için geçici değişkenlere ihtiyacimiz vardi, hata aliyorduk
        double tempMinPrice;
        if (scanner.hasNextDouble()) {
            tempMinPrice = scanner.nextDouble();
        } else {
            System.out.println("Invalid minimum price.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter maximum price: $");
        double tempMaxPrice;
        if (scanner.hasNextDouble()) {
            tempMaxPrice = scanner.nextDouble();
            scanner.nextLine(); // number inputtan sonra newline gerekiyor
        } else {
            System.out.println("Invalid maximum price.");
            scanner.nextLine();
            return;
        }

        final double minPrice = tempMinPrice;
        final double maxPrice = tempMaxPrice;


        System.out.println("Searching for items between $" + minPrice + " and $" + maxPrice + "...");

        Predicate<IStockable> priceCriteria = product ->
                product.getPrice() >= minPrice && product.getPrice() <= maxPrice;

        List<IStockable> results = manager.findItems(priceCriteria);

        if (results.isEmpty()) {
            System.out.println("No items found in this price range.");
        } else {
            System.out.println("\n--- Found Items ---");
            for (IStockable item : results) {
                item.displayDetails();
            }
            System.out.println("-------------------");
        }
    }
}

