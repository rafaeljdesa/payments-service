package br.com.example.payments.domain.model.discount;

import br.com.example.payments.domain.model.ShoppingCart;
import br.com.example.payments.domain.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DiscountFactory {

    private static final int QUANTITY_OF_INSTALLMENTS_FOR_DISCOUNT = 1;
    private static final BigDecimal AMOUNT_FOR_DISCOUNT_START = BigDecimal.valueOf(2000.01);
    private static final BigDecimal AMOUNT_FOR_DISCOUNT_END = BigDecimal.valueOf(5000.00);

    public static List<Discount> create(User user, ShoppingCart shoppingCart, int quantityOfInstallments) {
        List<Discount> discounts = new ArrayList<>();

        if (user.isEnabledForDiscount()) {
            discounts.add(new DiscountByAge());
        }

        if (quantityOfInstallments > QUANTITY_OF_INSTALLMENTS_FOR_DISCOUNT) {
            return discounts;
        }

        if (shoppingCart.getAmount().compareTo(AMOUNT_FOR_DISCOUNT_START) > -1 &&
            shoppingCart.getAmount().compareTo(AMOUNT_FOR_DISCOUNT_END) < 1) {
            discounts.add(new DiscountByPriceMedium());
        }

        if (shoppingCart.getAmount().compareTo(AMOUNT_FOR_DISCOUNT_END) > 0) {
            discounts.add(new DiscountByPriceHigh());
        }

        return discounts;
    }
}
