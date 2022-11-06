package br.com.example.payments.domain.model.interests;

import java.math.BigDecimal;

public class InterestsFromTwoToThreeInstallments implements Interests {

    private static final BigDecimal INTEREST = BigDecimal.ONE;

    @Override
    public BigDecimal get() {
        return INTEREST;
    }
}
