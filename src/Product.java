import java.util.UUID;

// Base class implementing the IStockable interface
public abstract class Product implements IStockable {
    protected String name;
    protected double price;
    protected int stock;
    protected final String productId;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        // Simple way to generate a unique ID
        this.productId = UUID.randomUUID().toString().substring(0, 8);
    }

    // Implementing interface methods
    @Override
    public void updateStock(int amount) {
        this.stock += amount;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    // Abstract method to demonstrate polymorphism in subclasses
    @Override
    public abstract void displayDetails();
}
