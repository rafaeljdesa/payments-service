package br.com.example.payments.domain.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentOptions {

    public PaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public PaymentOptions() {
        this.paymentOptions = new ArrayList<>();
    }

    private final List<PaymentOption> paymentOptions;

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }
}
