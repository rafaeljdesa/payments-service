package br.com.example.payments.domain.model.installments;

public class NumberOfInstallmentsPriceHigh implements NumberOfInstallments {

    private static final int QUANTITY = 12;

    @Override
    public int get() {
        return QUANTITY;
    }
}
