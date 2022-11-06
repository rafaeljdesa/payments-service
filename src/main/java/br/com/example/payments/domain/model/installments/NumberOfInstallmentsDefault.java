package br.com.example.payments.domain.model.installments;

public class NumberOfInstallmentsDefault implements NumberOfInstallments {

    private static final int QUANTITY = 3;

    @Override
    public int get() {
        return QUANTITY;
    }
}
