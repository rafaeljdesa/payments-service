package br.com.example.payments.domain.model.discount;

import br.com.example.payments.domain.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountFactoryTest {

    @Test
    public void should_return_a_valid_discounts_when_user_age_is_high_and_amount_is_medium() {
        User user = getUserEnabledToDiscount();
        ShoppingCart shoppingCart = getShoppingCartWithMediumAmount();

        List<Discount> discounts = DiscountFactory.create(user, shoppingCart, 1);

        assertEquals(2, discounts.size());
        assertEquals(BigDecimal.ONE, discounts.get(0).get());
        assertEquals(BigDecimal.valueOf(2.5), discounts.get(1).get());
    }

    @Test
    public void should_return_a_valid_discounts_when_user_age_is_high_and_amount_is_high() {
        User user = getUserEnabledToDiscount();
        ShoppingCart shoppingCart = getShoppingCartWithHighAmount();

        List<Discount> discounts = DiscountFactory.create(user, shoppingCart, 1);

        assertEquals(2, discounts.size());
        assertEquals(BigDecimal.ONE, discounts.get(0).get());
        assertEquals(BigDecimal.valueOf(5), discounts.get(1).get());
    }

    @Test
    public void should_return_a_valid_discounts_when_amount_is_medium() {
        User user = getUserUnabledToDiscount();
        ShoppingCart shoppingCart = getShoppingCartWithHighAmount();

        List<Discount> discounts = DiscountFactory.create(user, shoppingCart, 1);

        assertEquals(1, discounts.size());
        assertEquals(BigDecimal.valueOf(5), discounts.get(0).get());
    }

    @Test
    public void should_return_none_discounts_when_amount_is_low() {
        User user = getUserUnabledToDiscount();
        ShoppingCart shoppingCart = getShoppingCartWithLowAmount();

        List<Discount> discounts = DiscountFactory.create(user, shoppingCart, 1);

        assertEquals(0, discounts.size());
    }

    @Test
    public void should_return_none_discounts_when_amount_is_high_and_quantity_of_installments_bigger_than_one() {
        User user = getUserUnabledToDiscount();
        ShoppingCart shoppingCart = getShoppingCartWithLowAmount();

        List<Discount> discounts = DiscountFactory.create(user, shoppingCart, 2);

        assertEquals(0, discounts.size());
    }

    private ShoppingCart getShoppingCartWithMediumAmount() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(2500.00), ProductCategory.MOBILE_PHONE), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithHighAmount() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(6299.99), ProductCategory.MOBILE_PHONE), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithLowAmount() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(300), ProductCategory.MOBILE_PHONE), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private User getUserEnabledToDiscount() {
        return new User("Test", "Test", 61);
    }

    private User getUserUnabledToDiscount() {
        return new User("Test", "Test", 30);
    }
}