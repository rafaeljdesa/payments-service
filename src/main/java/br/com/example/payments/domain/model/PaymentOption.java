package br.com.example.payments.domain.model;

import java.math.BigDecimal;

public class PaymentOption {

    public PaymentOption(int numberOfInstallments,
                         BigDecimal amount) {
        this.numberOfInstallments = numberOfInstallments;
        this.amount = amount;
    }

    public PaymentOption() {
        this.numberOfInstallments = 0;
        this.amount = null;
    }

    private final int numberOfInstallments;
    private final BigDecimal amount;

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
