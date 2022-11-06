package br.com.example.payments.domain.model;

public class ShoppingCartItem {

    public ShoppingCartItem(Product product,
                            int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ShoppingCartItem() {
        this.product = null;
        this.quantity = 0;
    }

    private final Product product;
    private final int quantity;

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
