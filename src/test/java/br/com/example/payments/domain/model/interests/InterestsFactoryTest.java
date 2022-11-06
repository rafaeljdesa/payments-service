package br.com.example.payments.domain.model.interests;

import br.com.example.payments.domain.exception.InvalidQuantityOfInstallmentsException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class InterestsFactoryTest {

    @Test
    public void should_create_interest_to_one_installment_when_quantity_is_one() {
        int quantityOfInstallment = 1;
        Interests interests = InterestsFactory.create(quantityOfInstallment);
        assertEquals(BigDecimal.ZERO, interests.get());
    }

    @Test
    public void should_create_interest_to_two_or_three_installment_when_quantity_is_two() {
        int quantityOfInstallment = 2;
        Interests interests = InterestsFactory.create(quantityOfInstallment);
        assertEquals(BigDecimal.ONE, interests.get());
    }

    @Test
    public void should_create_interest_to_two_or_three_installment_when_quantity_is_three() {
        int quantityOfInstallment = 3;
        Interests interests = InterestsFactory.create(quantityOfInstallment);
        assertEquals(BigDecimal.ONE, interests.get());
    }

    @Test
    public void should_create_interest_from_four_to_six_installment_when_quantity_is_four() {
        int quantityOfInstallment = 4;
        Interests interests = InterestsFactory.create(quantityOfInstallment);
        assertEquals(BigDecimal.valueOf(2), interests.get());
    }

    @Test
    public void should_create_interest_from_seven_to_twelve_installment_when_quantity_is_twelve() {
        int quantityOfInstallment = 12;
        Interests interests = InterestsFactory.create(quantityOfInstallment);
        assertEquals(BigDecimal.valueOf(3), interests.get());
    }

    @Test
    public void should_throw_exception_when_quantity_is_invalid() {
        int quantityOfInstallment = 13;
        assertThrows(InvalidQuantityOfInstallmentsException.class,
                () -> InterestsFactory.create(quantityOfInstallment));
    }

}