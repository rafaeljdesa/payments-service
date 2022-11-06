package br.com.example.payments.domain.model.installments;

import br.com.example.payments.domain.model.Product;
import br.com.example.payments.domain.model.ProductCategory;
import br.com.example.payments.domain.model.ShoppingCart;
import br.com.example.payments.domain.model.ShoppingCartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfInstallmentsFactoryTest {

    @Test
    public void should_create_a_valid_installments_when_contains_home_applicance_or_mobile_phone_products() {
        ShoppingCart shoppingCart = getShoppingCartWithHomeApplianceAndMobilePhone();
        NumberOfInstallments numberOfInstallments = NumberOfInstallmentsFactory.create(shoppingCart);
        assertEquals(12, numberOfInstallments.get());
    }

    @Test
    public void should_create_a_valid_installments_when_contains_eletronic_products() {
        ShoppingCart shoppingCart = getShoppingCartWithEletronic();
        NumberOfInstallments numberOfInstallments = NumberOfInstallmentsFactory.create(shoppingCart);
        assertEquals(6, numberOfInstallments.get());
    }

    @Test
    public void should_create_a_valid_installments_when_contains_default_products() {
        ShoppingCart shoppingCart = getShoppingCartWithDefault();
        NumberOfInstallments numberOfInstallments = NumberOfInstallmentsFactory.create(shoppingCart);
        assertEquals(3, numberOfInstallments.get());
    }

    @Test
    public void should_create_a_valid_installments_when_contains_high_amount() {
        ShoppingCart shoppingCart = getShoppingCartWithHighAmount();
        NumberOfInstallments numberOfInstallments = NumberOfInstallmentsFactory.create(shoppingCart);
        assertEquals(12, numberOfInstallments.get());
    }

    @Test
    public void should_create_a_valid_installments_when_mobile_phone_and_eletronic_products() {
        ShoppingCart shoppingCart = getShoppingCartWithMobilePhoneAndEletronic();
        NumberOfInstallments numberOfInstallments = NumberOfInstallmentsFactory.create(shoppingCart);
        assertEquals(12, numberOfInstallments.get());
    }

    private ShoppingCart getShoppingCartWithHomeApplianceAndMobilePhone() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.HOME_APPLIANCE), 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(new Product("Product 2", BigDecimal.valueOf(5699.90), ProductCategory.MOBILE_PHONE), 1);
        return new ShoppingCart(List.of(shoppingCartItem1, shoppingCartItem2));
    }

    private ShoppingCart getShoppingCartWithEletronic() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.ELECTRONIC), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithDefault() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.DECOR), 1);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithHighAmount() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.DECOR), 10);
        return new ShoppingCart(List.of(shoppingCartItem1));
    }

    private ShoppingCart getShoppingCartWithMobilePhoneAndEletronic() {
        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(new Product("Product 1", BigDecimal.valueOf(1299.99), ProductCategory.MOBILE_PHONE), 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(new Product("Product 2", BigDecimal.valueOf(1299.99), ProductCategory.ELECTRONIC), 1);
        return new ShoppingCart(List.of(shoppingCartItem1, shoppingCartItem2));
    }
}