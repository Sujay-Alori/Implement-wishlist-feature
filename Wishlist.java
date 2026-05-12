import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private int wishlistId;
    private String userName;
    private List<Product> products;

    public Wishlist(int wishlistId, String userName) {
        this.wishlistId = wishlistId;
        this.userName = userName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getProductId() == productId);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return products.stream()
                       .mapToDouble(Product::getPrice)
                       .sum();
    }

    public boolean isProductInWishlist(int productId) {
        return products.stream()
                       .anyMatch(p -> p.getProductId() == productId);
    }

    public void displayWishlist() {
        System.out.println("Wishlist ID: " + wishlistId + " | User: " + userName);
        if (products.isEmpty()) {
            System.out.println("Wishlist is empty");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }
}
