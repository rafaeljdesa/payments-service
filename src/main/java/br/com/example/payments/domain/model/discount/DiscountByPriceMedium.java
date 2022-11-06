package br.com.example.payments.domain.model.discount;

import java.math.BigDecimal;

public class DiscountByPriceMedium implements Discount {

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(2.5);

    @Override
    public BigDecimal get() {
        return DISCOUNT;
    }
}
