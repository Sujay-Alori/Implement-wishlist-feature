import java.util.HashMap;
import java.util.Map;

public class WishlistManager {
    private Map<String, Wishlist> userWishlists;

    public WishlistManager() {
        this.userWishlists = new HashMap<>();
    }

    public void createWishlist(int id, String userName) {
        if (!userWishlists.containsKey(userName)) {
            userWishlists.put(userName, new Wishlist(id, userName));
            System.out.println("Created wishlist for user: " + userName);
        } else {
            System.out.println("Wishlist already exists for user: " + userName);
        }
    }

    public Wishlist getWishlist(String userName) {
        return userWishlists.get(userName);
    }

    public void addToWishlist(String userName, Product product) {
        Wishlist wishlist = userWishlists.get(userName);
        if (wishlist != null) {
            wishlist.addProduct(product);
        } else {
            System.out.println("No wishlist found for user: " + userName);
        }
    }

    public void removeFromWishlist(String userName, int productId) {
        Wishlist wishlist = userWishlists.get(userName);
        if (wishlist != null) {
            wishlist.removeProduct(productId);
        } else {
            System.out.println("No wishlist found for user: " + userName);
        }
    }

    public void viewWishlist(String userName) {
        Wishlist wishlist = userWishlists.get(userName);
        if (wishlist != null) {
            wishlist.displayWishlist();
        } else {
            System.out.println("No wishlist found for user: " + userName);
        }
    }
}
