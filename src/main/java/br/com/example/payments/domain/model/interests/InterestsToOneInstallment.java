package br.com.example.payments.domain.model.interests;

import java.math.BigDecimal;

public class InterestsToOneInstallment implements Interests {

    private static final BigDecimal INTEREST = BigDecimal.ZERO;

    @Override
    public BigDecimal get() {
        return INTEREST;
    }
}
