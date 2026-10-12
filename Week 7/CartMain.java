class Cart {
private final int[] prices;
private final String cartId;
private int count;

public Cart(String cartId, int capacity) {
    this.cartId = cartId;
    prices = new int[capacity];
    count = 0;
}

public void addItem(int price) {
    if (price > 0 && count < prices.length) {
        prices[count] = price;
        count++;
    }
}

public int getTotal() {
    int total = 0;

    for (int i = 0; i < count; i++) {
        total += prices[i];
    }

    return total;
}

public int getItemCount() {
    return count;
}

public String getCartId() {
    return cartId;
}

}

public class CartMain {
public static void main(String[] args) {
Cart cart = new Cart("CART-5", 20);

    cart.addItem(250);
    cart.addItem(99);
    cart.addItem(151);

    System.out.println("Cart ID: " + cart.getCartId());
    System.out.println("Total: " + cart.getTotal());
    System.out.println("Item Count: " + cart.getItemCount());
}

}