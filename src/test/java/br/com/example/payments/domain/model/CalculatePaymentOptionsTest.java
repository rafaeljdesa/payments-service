package br.com.example.payments.domain.model;

import br.com.example.payments.domain.model.discount.Discount;
import br.com.example.payments.domain.model.discount.DiscountByPriceHigh;
import br.com.example.payments.domain.model.discount.DiscountByPriceMedium;
import br.com.example.payments.domain.model.interests.Interests;
import br.com.example.payments.domain.model.interests.InterestsFromTwoToThreeInstallments;
import br.com.example.payments.domain.model.interests.InterestsToOneInstallment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatePaymentOptionsTest {

    @Test
    public void should_return_a_valid_amout_when_one_installment_and_product_price_low() {
        BigDecimal productPrice = BigDecimal.valueOf(299.99);
        int quantityOfInstallment = 1;
        Interests interests = new InterestsToOneInstallment();
        CalculatePaymentOptions paymentOption = new CalculatePaymentOptions(
                productPrice,
                quantityOfInstallment,
                interests
        );
        assertEquals(BigDecimal.valueOf(299.99), paymentOption.getAmount());
    }

    @Test
    public void should_return_a_valid_amout_when_one_installment_and_product_price_medium() {
        BigDecimal productPrice = BigDecimal.valueOf(2599.99);
        int quantityOfInstallment = 1;
        Interests interests = new InterestsToOneInstallment();
        List<Discount> discounts = List.of(new DiscountByPriceMedium());
        CalculatePaymentOptions paymentOption = new CalculatePaymentOptions(
                productPrice,
                quantityOfInstallment,
                interests,
                discounts
        );
        assertEquals(BigDecimal.valueOf(2534.99), paymentOption.getAmount());
    }

    @Test
    public void should_return_a_valid_amout_when_one_installment_and_product_price_high() {
        BigDecimal productPrice = BigDecimal.valueOf(5250.49);
        int quantityOfInstallment = 1;
        Interests interests = new InterestsToOneInstallment();
        List<Discount> discounts = List.of(new DiscountByPriceHigh());
        CalculatePaymentOptions paymentOption = new CalculatePaymentOptions(
                productPrice,
                quantityOfInstallment,
                interests,
                discounts
        );
        assertEquals(BigDecimal.valueOf(4987.97), paymentOption.getAmount());
    }

    @Test
    public void should_return_a_valid_amout_when_two_installment_and_product_price_high() {
        BigDecimal productPrice = BigDecimal.valueOf(3599.50);
        int quantityOfInstallment = 2;
        Interests interests = new InterestsFromTwoToThreeInstallments();
        CalculatePaymentOptions paymentOption = new CalculatePaymentOptions(
                productPrice,
                quantityOfInstallment,
                interests
        );
        assertEquals(BigDecimal.valueOf(1817.75), paymentOption.getAmount());
    }
}