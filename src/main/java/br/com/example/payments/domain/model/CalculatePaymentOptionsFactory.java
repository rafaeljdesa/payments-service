package br.com.example.payments.domain.model;

import java.util.List;

public class CalculatePaymentOptionsFactory {

    public static CalculatePaymentOptionsResponse create(List<PaymentOption> paymentOptions) {
        PaymentOptions paymentOptionsObj = new PaymentOptions(paymentOptions);
        return new CalculatePaymentOptionsResponse(paymentOptionsObj);
    }

}
