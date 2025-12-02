import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Predicate;

// Generic Class restricted to types that implement IStockable
public class StockManager<T extends IStockable> {

    // 1. Generic Collection: List (Main Storage)
    private List<T> stockList;

    // 2. Generic Collection: Set (To track unique product names)
    private Set<String> productNames;

    public StockManager() {
        this.stockList = new ArrayList<>();
        this.productNames = new HashSet<>();
    }

    /**
     * Adds an item to the stock, checking for duplicate names using Set.
     * @param item The item to add.
     */
    public void addItem(T item) {
        if (productNames.contains(item.getName())) {
            System.out.println("Error: Product with name '" + item.getName() + "' already exists.");
            return;
        }

        stockList.add(item);
        productNames.add(item.getName());
        System.out.println(item.getName() + " added to stock.");
    }

    /**
     * Lists all items in the stock.
     */
    public void listAllItems() {
        if (stockList.isEmpty()) {
            System.out.println("Stock is currently empty.");
            return;
        }
        System.out.println("\n--- Current Stock List ---");
        // Polymorphism in action: calling displayDetails()
        for (T item : stockList) {
            item.displayDetails();
        }
        System.out.println("--------------------------");
    }

    /**
     * Finds items matching a generic predicate (Lambda function).
     * @param criteria A Predicate defining the search criteria (Lambda).
     * @return A list of matching items.
     */
    // Generic method that uses a Lambda function (Predicate)
    public List<T> findItems(Predicate<T> criteria) {
        List<T> foundItems = new ArrayList<>();
        // Lambda function usage: filtering the list
        for (T item : stockList) {
            if (criteria.test(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    /**
     * Simple utility to find item by name.
     */
    // Generic method to find an item by name
    public T findItemByName(String name) {
        for (T item : stockList) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
