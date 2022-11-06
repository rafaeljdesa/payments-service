package br.com.example.payments.domain.model.discount;

import java.math.BigDecimal;

public class DiscountByAge implements Discount {

    private static final BigDecimal DISCOUNT = BigDecimal.ONE;

    @Override
    public BigDecimal get() {
        return DISCOUNT;
    }
}
