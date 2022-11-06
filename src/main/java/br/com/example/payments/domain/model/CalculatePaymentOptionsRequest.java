package br.com.example.payments.domain.model;

public class CalculatePaymentOptionsRequest {

    public CalculatePaymentOptionsRequest(User user,
                                          ShoppingCart shoppingCart) {
        this.user = user;
        this.shoppingCart = shoppingCart;
    }

    public CalculatePaymentOptionsRequest() {
        this.user = null;
        this.shoppingCart = null;
    }

    private final User user;
    private final ShoppingCart shoppingCart;

    public User getUser() {
        return user;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
