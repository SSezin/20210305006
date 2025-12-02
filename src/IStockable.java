public interface IStockable {
    /**
     * Updates the stock quantity by a given amount.
     * @param amount The quantity to add or subtract.
     */
    void updateStock(int amount);

    /**
     * Displays the full details of the product.
     */
    void displayDetails();

    /**
     * Gets the current stock quantity.
     * @return The current stock quantity.
     */
    int getStock();

    /**
     * Gets the price of the product.
     * @return The price.
     */
    double getPrice();

    /**
     * Gets the name of the product.
     * @return The product name.
     */
    String getName();
}