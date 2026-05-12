public class Main {
    public static void main(String[] args) {
        // 1. Create WishlistManager instance
        WishlistManager manager = new WishlistManager();

        // 2. Create sample Product objects
        Product laptop = new Product(101, "MacBook Air", 1200.00, "Electronics");
        Product coffeeMaker = new Product(102, "Espresso Machine", 250.50, "Home Appliances");
        Product deskLamp = new Product(103, "LED Desk Lamp", 45.99, "Furniture");

        // 3. Create wishlists for 2 users
        System.out.println("--- System Initialization ---");
        manager.createWishlist(1, "Alice");
        manager.createWishlist(2, "Bob");

        // 4. Add products to each user's wishlist
        System.out.println("\n--- Adding Products ---");
        manager.addToWishlist("Alice", laptop);
        manager.addToWishlist("Alice", coffeeMaker);
        
        manager.addToWishlist("Bob", deskLamp);
        manager.addToWishlist("Bob", laptop); // Both users want a laptop

        // 5. Display each wishlist
        System.out.println("\n--- Displaying Wishlists ---");
        System.out.println("Alice's Wishlist:");
        manager.viewWishlist("Alice");
        System.out.printf("Total Value: $%.2f\n", manager.getWishlist("Alice").getTotalPrice());

        System.out.println("\nBob's Wishlist:");
        manager.viewWishlist("Bob");
        System.out.printf("Total Value: $%.2f\n", manager.getWishlist("Bob").getTotalPrice());

        // 6. Remove one product from Alice's wishlist
        System.out.println("\n--- Removing 'Espresso Machine' (ID: 102) from Alice's Wishlist ---");
        manager.removeFromWishlist("Alice", 102);

        // 7. Display Alice's updated wishlist
        System.out.println("\n--- Alice's Updated Wishlist ---");
        manager.viewWishlist("Alice");
        System.out.printf("Total Value: $%.2f\n", manager.getWishlist("Alice").getTotalPrice());
    }
}
