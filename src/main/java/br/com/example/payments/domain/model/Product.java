package br.com.example.payments.domain.model;

import java.math.BigDecimal;

public class Product {

    public Product(String title,
                   BigDecimal price,
                   ProductCategory category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public Product() {
        this.title = null;
        this.price = null;
        this.category = null;
    }

    private final String title;
    private final BigDecimal price;
    private final ProductCategory category;

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
