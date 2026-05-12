// Replicating Java Logic in JavaScript
class Product {
    constructor(productId, name, price, category, emoji) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.emoji = emoji;
    }
}

class Wishlist {
    constructor(wishlistId, userName) {
        this.wishlistId = wishlistId;
        this.userName = userName;
        this.products = [];
    }

    addProduct(product) {
        this.products.push(product);
    }

    removeProduct(productId) {
        this.products = this.products.filter(p => p.productId !== productId);
    }

    getTotalPrice() {
        return this.products.reduce((sum, p) => sum + p.price, 0);
    }
}

class WishlistManager {
    constructor() {
        this.userWishlists = new Map();
    }

    createWishlist(id, userName) {
        if (!this.userWishlists.has(userName)) {
            this.userWishlists.set(userName, new Wishlist(id, userName));
        }
    }

    getWishlist(userName) {
        return this.userWishlists.get(userName);
    }
}

// --- Application Logic ---

const manager = new WishlistManager();
const availableProducts = [
    new Product(101, "MacBook Air", 1200.00, "Electronics", "💻"),
    new Product(102, "Espresso Machine", 250.50, "Appliances", "☕"),
    new Product(103, "LED Desk Lamp", 45.99, "Furniture", "💡"),
    new Product(104, "Headphones", 199.99, "Electronics", "🎧"),
    new Product(105, "Gaming Mouse", 79.00, "Electronics", "🖱️"),
    new Product(106, "Smart Watch", 349.00, "Electronics", "⌚")
];

let currentUser = "Alice";

// Initialize Data
manager.createWishlist(1, "Alice");
manager.createWishlist(2, "Bob");
manager.createWishlist(3, "Charlie");

// DOM Elements
const productGrid = document.getElementById('productGrid');
const wishlistItems = document.getElementById('wishlistItems');
const totalValueDisplay = document.getElementById('totalValue');
const userSelector = document.getElementById('userSelector');
const currentUserNameLabel = document.getElementById('currentUserName');

function renderUsers() {
    userSelector.innerHTML = '';
    ["Alice", "Bob", "Charlie"].forEach(user => {
        const btn = document.createElement('button');
        btn.className = `user-btn ${user === currentUser ? 'active' : ''}`;
        btn.textContent = user;
        btn.onclick = () => {
            currentUser = user;
            renderUsers();
            renderWishlist();
        };
        userSelector.appendChild(btn);
    });
}

function renderCatalog() {
    productGrid.innerHTML = '';
    availableProducts.forEach(product => {
        const card = document.createElement('div');
        card.className = 'glass-card product-card';
        card.innerHTML = `
            <div class="product-image">${product.emoji}</div>
            <div class="product-info">
                <div class="product-category">${product.category}</div>
                <h3>${product.name}</h3>
                <div class="product-footer">
                    <span class="price">$${product.price.toFixed(2)}</span>
                    <button class="add-btn" onclick="addToWishlist(${product.productId})">Add</button>
                </div>
            </div>
        `;
        productGrid.appendChild(card);
    });
}

function renderWishlist() {
    currentUserNameLabel.textContent = currentUser;
    const wishlist = manager.getWishlist(currentUser);
    wishlistItems.innerHTML = '';

    if (wishlist.products.length === 0) {
        wishlistItems.innerHTML = '<div class="empty-msg">Your wishlist is empty. Add some magic!</div>';
    } else {
        wishlist.products.forEach(product => {
            const li = document.createElement('li');
            li.className = 'wishlist-item';
            li.innerHTML = `
                <div style="font-size: 1.5rem">${product.emoji}</div>
                <div class="wishlist-item-info">
                    <div style="font-weight: 600">${product.name}</div>
                    <div style="color: var(--accent); font-size: 0.9rem">$${product.price.toFixed(2)}</div>
                </div>
                <button class="remove-btn" onclick="removeFromWishlist(${product.productId})">×</button>
            `;
            wishlistItems.appendChild(li);
        });
    }

    totalValueDisplay.textContent = `$${wishlist.getTotalPrice().toFixed(2)}`;
}

window.addToWishlist = (id) => {
    const product = availableProducts.find(p => p.productId === id);
    const wishlist = manager.getWishlist(currentUser);
    
    // Prevent duplicates for demo clarity
    if (!wishlist.products.some(p => p.productId === id)) {
        wishlist.addProduct(product);
        renderWishlist();
    }
};

window.removeFromWishlist = (id) => {
    const wishlist = manager.getWishlist(currentUser);
    wishlist.removeProduct(id);
    renderWishlist();
};

// Initial Render
renderUsers();
renderCatalog();
renderWishlist();
