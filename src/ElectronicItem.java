public class ElectronicItem extends Product {
    private int warrantyMonths;

    public ElectronicItem(String name, double price, int stock, int warrantyMonths) {
        super(name, price, stock);
        this.warrantyMonths = warrantyMonths;
    }

    // Polymorphism: Specific implementation for ElectronicItem
    @Override
    public void displayDetails() {
        System.out.println("💻 ELECTRONIC ID: " + productId + ", Name: " + name +
                ", Warranty: " + warrantyMonths + " months, Price: $" + price +
                ", Stock: " + stock);
    }

    // Other ElectronicItem specific methods could go here
    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}
