package br.com.example.payments.domain.model.discount;

import java.math.BigDecimal;

public class DiscountByPriceHigh implements Discount {

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(5);

    @Override
    public BigDecimal get() {
        return DISCOUNT;
    }
}
