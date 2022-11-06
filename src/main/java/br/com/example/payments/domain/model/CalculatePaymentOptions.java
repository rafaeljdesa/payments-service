package br.com.example.payments.domain.model;

import br.com.example.payments.domain.model.discount.Discount;
import br.com.example.payments.domain.model.interests.Interests;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CalculatePaymentOptions {

    private static final int ONE_HUNDRED = 100;
    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    public CalculatePaymentOptions(BigDecimal productPrice,
                                   int quantityOfInstallments,
                                   Interests interests,
                                   List<Discount> discounts) {
        this.productPrice = productPrice;
        this.quantityOfInstallments = quantityOfInstallments;
        this.interests = interests;
        this.discounts = discounts;
    }

    public CalculatePaymentOptions(BigDecimal productPrice,
                                   int quantityOfInstallments,
                                   Interests interests) {
        this.productPrice = productPrice;
        this.quantityOfInstallments = quantityOfInstallments;
        this.interests = interests;
        this.discounts = new ArrayList<>();
    }

    private final BigDecimal productPrice;
    private final int quantityOfInstallments;
    private final Interests interests;
    private final List<Discount> discounts;

    public BigDecimal getAmount() {
        BigDecimal interests = getPercentageValue(this.interests.get(), productPrice);

        BigDecimal totalDiscounts = this.discounts.stream()
                .map(discount -> this.getPercentageValue(discount.get(), productPrice))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalAmount = productPrice
                .add(interests)
                .subtract(totalDiscounts);

        return totalAmount.divide(BigDecimal.valueOf(quantityOfInstallments), SCALE, ROUNDING_MODE);
    }

    public int getNumberOfInstallments() {
        return quantityOfInstallments;
    }

    private BigDecimal getPercentageValue(BigDecimal percentage, BigDecimal from) {
        return percentage
                .divide(BigDecimal.valueOf(ONE_HUNDRED))
                .multiply(from).setScale(SCALE, ROUNDING_MODE);
    }

}
