package br.com.example.payments.domain.service;

import br.com.example.payments.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatePaymentsOptionsServiceTest {

    private CalculatePaymentsOptionsService calculatePaymentsOptionsService;

    @BeforeEach
    public void setup() {
        calculatePaymentsOptionsService = new CalculatePaymentsOptionsService();
    }

    @Test
    public void should_calculate_payment_options_when_shopping_cart_contains_mobile_phone() {
        CalculatePaymentOptionsRequest request = getRequestWithMobilePhone();

        CalculatePaymentOptionsResponse paymentOptionsResponse = calculatePaymentsOptionsService.calculate(request);

        assertEquals(12, paymentOptionsResponse.getPaymentOptions().getPaymentOptions().size());
    }

    @Test
    public void should_calculate_payment_options_when_shopping_cart_contains_home_appliance() {
        CalculatePaymentOptionsRequest request = getRequestWithHomeApplicance();

        CalculatePaymentOptionsResponse paymentOptionsResponse = calculatePaymentsOptionsService.calculate(request);

        assertEquals(12, paymentOptionsResponse.getPaymentOptions().getPaymentOptions().size());
    }

    @Test
    public void should_calculate_payment_options_when_shopping_cart_contains_eletronic() {
        CalculatePaymentOptionsRequest request = getRequestWithEletronic();

        CalculatePaymentOptionsResponse paymentOptionsResponse = calculatePaymentsOptionsService.calculate(request);

        assertEquals(6, paymentOptionsResponse.getPaymentOptions().getPaymentOptions().size());
    }

    @Test
    public void should_calculate_payment_options_when_shopping_cart_contains_decor() {
        CalculatePaymentOptionsRequest request = getRequestWithDecor();

        CalculatePaymentOptionsResponse paymentOptionsResponse = calculatePaymentsOptionsService.calculate(request);

        assertEquals(3, paymentOptionsResponse.getPaymentOptions().getPaymentOptions().size());
    }

    @Test
    public void should_calculate_payment_options_when_shopping_cart_contains_high_amount() {
        CalculatePaymentOptionsRequest request = getRequestWithHighAmount();

        CalculatePaymentOptionsResponse paymentOptionsResponse = calculatePaymentsOptionsService.calculate(request);

        assertEquals(12, paymentOptionsResponse.getPaymentOptions().getPaymentOptions().size());
    }

    private CalculatePaymentOptionsRequest getRequestWithMobilePhone() {
        User user = getUser();
        ShoppingCart shoppingCart = getShoppingCartWithMobilePhoneAndEletronic();
        return new CalculatePaymentOptionsRequest(user, shoppingCart);
    }

    private CalculatePaymentOptionsRequest getRequestWithHomeApplicance() {
        User user = getUser();
        ShoppingCart shoppingCart = getShoppingCartWithHomeApplianceAndEletronic();
        return new CalculatePaymentOptionsRequest(user, shoppingCart);
    }

    private CalculatePaymentOptionsRequest getRequestWithEletronic() {
        User user = getUser();
        ShoppingCart shoppingCart = getShoppingCartWithEletronic();
        return new CalculatePaymentOptionsRequest(user, shoppingCart);
    }

    private CalculatePaymentOptionsRequest getRequestWithDecor() {
        User user = getUser();
        ShoppingCart shoppingCart = getShoppingCartWithDecor();
        return new CalculatePaymentOptionsRequest(user, shoppingCart);
    }

    private CalculatePaymentOptionsRequest getRequestWithHighAmount() {
        User user = getUser();
        ShoppingCart shoppingCart = getShoppingCartWithHighAmount();
        return new CalculatePaymentOptionsRequest(user, shoppingCart);
    }

    private ShoppingCart getShoppingCartWithMobilePhoneAndEletronic() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.MOBILE_PHONE), 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(new Product("Product 2", BigDecimal.valueOf(1299.99), ProductCategory.ELECTRONIC), 1);
        return new ShoppingCart(List.of(shoppingCartItem1, shoppingCartItem2));
    }

    private ShoppingCart getShoppingCartWithHomeApplianceAndEletronic() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.HOME_APPLIANCE), 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(new Product("Product 2", BigDecimal.valueOf(1299.99), ProductCategory.ELECTRONIC), 1);
        return new ShoppingCart(List.of(shoppingCartItem1, shoppingCartItem2));
    }

    private ShoppingCart getShoppingCartWithEletronic() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.ELECTRONIC), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithDecor() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.DECOR), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithHighAmount() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.DECOR), 5);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private User getUser() {
        return new User("Test", "Test", 30);
    }
}