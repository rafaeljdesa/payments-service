package br.com.example.payments.domain.model.installments;

public class NumberOfInstallmentsEletronic implements NumberOfInstallments {

    private static final int QUANTITY = 6;

    @Override
    public int get() {
        return QUANTITY;
    }
}
