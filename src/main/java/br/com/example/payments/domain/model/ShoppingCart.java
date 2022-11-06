package br.com.example.payments.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public ShoppingCart(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    private final List<ShoppingCartItem> items;

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public boolean containsProductCategory(ProductCategory productCategory) {
        return items.stream()
                .anyMatch(item -> productCategory.equals(item.getProduct().getCategory()));
    }

    public BigDecimal getAmount() {
        return items.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
