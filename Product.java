public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format(
            "Product [ID: %d, Name: %-15s, Price: $%.2f, Category: %s]",
            productId, name, price, category
        );
    }
}
