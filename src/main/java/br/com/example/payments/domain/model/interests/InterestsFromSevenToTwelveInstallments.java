package br.com.example.payments.domain.model.interests;

import java.math.BigDecimal;

public class InterestsFromSevenToTwelveInstallments implements Interests {

    private static final BigDecimal INTEREST = BigDecimal.valueOf(3);

    @Override
    public BigDecimal get() {
        return INTEREST;
    }
}
