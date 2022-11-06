package br.com.example.payments.domain.model;

public class CalculatePaymentOptionsResponse {

    public CalculatePaymentOptionsResponse(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public CalculatePaymentOptionsResponse() {
        this.paymentOptions = null;
    }

    private final PaymentOptions paymentOptions;

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }
}
