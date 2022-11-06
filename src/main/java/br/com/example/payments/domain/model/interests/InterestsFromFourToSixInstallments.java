package br.com.example.payments.domain.model.interests;

import java.math.BigDecimal;

public class InterestsFromFourToSixInstallments implements Interests {

    private static final BigDecimal INTEREST = BigDecimal.valueOf(2);

    @Override
    public BigDecimal get() {
        return INTEREST;
    }
}
