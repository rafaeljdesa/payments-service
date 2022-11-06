package br.com.example.payments.domain.model.installments;

import br.com.example.payments.domain.model.ProductCategory;
import br.com.example.payments.domain.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberOfInstallmentsFactory {

    private static final BigDecimal FIVE_THOUSAND = BigDecimal.valueOf(5000.00);

    public static NumberOfInstallments create(ShoppingCart shoppingCart) {

        List<NumberOfInstallments> possibleInstallments = new ArrayList<>();

        if (shoppingCart.containsProductCategory(ProductCategory.HOME_APPLIANCE) ||
            shoppingCart.containsProductCategory(ProductCategory.MOBILE_PHONE)) {
            possibleInstallments.add(new NumberOfInstallmentsHomeApplianceOrMobile());
        }

        if (shoppingCart.containsProductCategory(ProductCategory.ELECTRONIC)) {
            possibleInstallments.add(new NumberOfInstallmentsEletronic());
        }

        if (FIVE_THOUSAND.compareTo(shoppingCart.getAmount()) < 0) {
            possibleInstallments.add(new NumberOfInstallmentsPriceHigh());
        }

        return getTheMaximumNumberOfInstallments(possibleInstallments);
    }

    private static NumberOfInstallments getTheMaximumNumberOfInstallments(List<NumberOfInstallments> possibleInstallments) {
        return possibleInstallments.stream()
                .reduce((a, b) -> a.get() > b.get() ? a : b)
                .orElse(new NumberOfInstallmentsDefault());
    }
}
