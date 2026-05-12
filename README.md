# Wishlist Feature Implementation

A comprehensive wishlist management system with both Java backend and web-based frontend interfaces.

## 📋 Overview

This project implements a full-featured wishlist management system that allows users to create, manage, and track their product wishlists. The system includes product catalog management, multi-user support, and both command-line and web-based interfaces.

## ✨ Features

### Core Functionality
- **Multi-User Wishlist Management**: Create separate wishlists for different users
- **Product Management**: Add, remove, and track products in wishlists
- **Price Tracking**: Automatically calculate total wishlist values
- **Product Categorization**: Organize products by category
- **Duplicate Prevention**: Avoid adding duplicate products to wishlists

### User Interfaces
- **Java CLI**: Command-line interface with object-oriented design
- **Web Interface**: Modern, responsive web-based UI with real-time updates
  - Premium glassmorphism design
  - Multi-user selection
  - Product catalog browsing
  - Real-time price calculations

## 📁 Project Structure

```
├── Java Backend (Backend Logic)
│   ├── Main.java              # Entry point demonstrating system usage
│   ├── Product.java           # Product model with ID, name, price, category
│   ├── Wishlist.java          # Single wishlist implementation
│   └── WishlistManager.java    # Central manager for all wishlists
│
├── Web Frontend (UI)
│   ├── index.html             # HTML structure
│   ├── index.css              # Styling with glassmorphism effect
│   └── index.js               # JavaScript functionality and DOM manipulation
│
└── README.md                   # This file
```

## 🏗️ Architecture

### Java Classes

#### **Product.java**
Represents a product with:
- `productId`: Unique identifier
- `name`: Product name
- `price`: Product price
- `category`: Product category

```java
Product laptop = new Product(101, "MacBook Air", 1200.00, "Electronics");
```

#### **Wishlist.java**
Manages a single user's wishlist:
- `addProduct(Product p)`: Add a product to wishlist
- `removeProduct(int productId)`: Remove a product by ID
- `getTotalPrice()`: Calculate total wishlist value
- `displayWishlist()`: Display all products in wishlist

#### **WishlistManager.java**
Central manager for multiple user wishlists:
- `createWishlist(int id, String userName)`: Create new wishlist for user
- `addToWishlist(String userName, Product product)`: Add product to user's wishlist
- `removeFromWishlist(String userName, int productId)`: Remove product from wishlist
- `viewWishlist(String userName)`: Display user's wishlist
- `getWishlist(String userName)`: Retrieve user's wishlist object

### Web Interface
Modern, responsive UI built with HTML5, CSS3, and vanilla JavaScript featuring:
- Glassmorphism design aesthetic
- Real-time wishlist updates
- Multi-user support with easy switching
- Product grid catalog display
- Live price calculations

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher (for running Java backend)
- Modern web browser (for web interface)

### Running the Java Backend

1. **Compile all Java files:**
   ```bash
   javac Main.java Product.java Wishlist.java WishlistManager.java
   ```

2. **Run the application:**
   ```bash
   java Main
   ```

3. **Expected Output:**
   ```
   --- System Initialization ---
   Created wishlist for user: Alice
   Created wishlist for user: Bob

   --- Adding Products ---
   
   --- Displaying Wishlists ---
   Alice's Wishlist:
   Wishlist ID: 1 | User: Alice
   Product [ID: 101, Name: MacBook Air  , Price: $1200.00, Category: Electronics]
   Product [ID: 102, Name: Espresso Machine, Price: $250.50, Category: Home Appliances]
   Total Value: $1450.50

   Bob's Wishlist:
   Wishlist ID: 2 | User: Bob
   Product [ID: 103, Name: LED Desk Lamp, Price: $45.99, Category: Furniture]
   Product [ID: 101, Name: MacBook Air  , Price: $1200.00, Category: Electronics]
   Total Value: $1245.99

   --- Removing 'Espresso Machine' (ID: 102) from Alice's Wishlist ---

   --- Alice's Updated Wishlist ---
   Wishlist ID: 1 | User: Alice
   Product [ID: 101, Name: MacBook Air  , Price: $1200.00, Category: Electronics]
   Total Value: $1200.00
   ```

### Running the Web Interface

1. **Open in browser:**
   - Double-click `index.html` or
   - Open via local server (recommended):
     ```bash
     # Python 3
     python -m http.server 8000
     
     # Python 2
     python -m SimpleHTTPServer 8000
     ```

2. **Access the application:**
   - Navigate to `http://localhost:8000` (or file:// if opened directly)
   - Select users from the top selector
   - Browse and add products to wishlists
   - View real-time price calculations

## 📝 Usage Examples

### Java Example
```java
// Create manager
WishlistManager manager = new WishlistManager();

// Create products
Product laptop = new Product(101, "MacBook Air", 1200.00, "Electronics");

// Create user wishlist
manager.createWishlist(1, "Alice");

// Add product to wishlist
manager.addToWishlist("Alice", laptop);

// View wishlist
manager.viewWishlist("Alice");

// Get total value
double total = manager.getWishlist("Alice").getTotalPrice();
System.out.println("Total: $" + total);

// Remove product
manager.removeFromWishlist("Alice", 101);
```

### Web Interface
1. Select a user from the user selector buttons
2. Browse products in the curated catalog
3. Click "Add to Wishlist" to add products
4. View wishlist items in the sidebar
5. Remove items with the delete button
6. Watch the total value update in real-time

## 🎨 Features Highlight

### Java Implementation
- **Object-Oriented Design**: Clean class hierarchy with single responsibility
- **Functional Programming**: Stream API usage for filtering and mapping
- **Data Structures**: HashMap for O(1) user lookup, ArrayList for flexible product storage
- **Error Handling**: Graceful handling of non-existent users

### Web Implementation
- **Modern CSS**: Glassmorphism effects and smooth transitions
- **Responsive Design**: Works on desktop and mobile devices
- **DOM Manipulation**: Dynamic content injection without page refresh
- **State Management**: Client-side state management for real-time updates
- **User Experience**: Intuitive controls and visual feedback

## 📊 Sample Data

The system comes pre-configured with sample products:
- MacBook Air (Electronics) - $1200.00
- Espresso Machine (Home Appliances) - $250.50
- LED Desk Lamp (Furniture) - $45.99

And sample users:
- Alice
- Bob

## 🔧 Technical Details

### Time Complexity
- Create Wishlist: O(1)
- Add Product: O(1)
- Remove Product: O(n) where n = number of products in wishlist
- Calculate Total: O(n) where n = number of products
- View Wishlist: O(n)

### Space Complexity
- O(n*m) where n = number of users and m = average products per wishlist

## 🎓 Learning Outcomes

This project demonstrates:
- Java OOP principles (encapsulation, inheritance, abstraction)
- Collection Framework (ArrayList, HashMap)
- Functional Programming (Streams, Lambda expressions)
- Web Development (HTML5, CSS3, Vanilla JavaScript)
- System Design (Multi-layer architecture)
- UI/UX Best Practices

## 📚 Technologies Used

**Backend:**
- Java 8+
- Collections Framework (HashMap, ArrayList)
- Streams API

**Frontend:**
- HTML5
- CSS3 (Flexbox, Grid, Glassmorphism)
- Vanilla JavaScript (ES6+)
- Google Fonts (Outfit)

## 📄 License

This project is provided as an educational implementation.

## 👤 Author

**Sujay-Alori**

---

**Last Updated:** May 12, 2026

For questions or contributions, feel free to open an issue or submit a pull request!
