public class Book extends Product {
    private String author;

    public Book(String name, double price, int stock, String author) {
        super(name, price, stock);
        this.author = author;
    }

    // Polymorphism: Specific implementation for Book
    @Override
    public void displayDetails() {
        System.out.println("📚 BOOK ID: " + productId + ", Name: " + name +
                ", Author: " + author + ", Price: $" + price +
                ", Stock: " + stock);
    }

    // Other Book specific methods could go here
    public String getAuthor() {
        return author;
    }
}
