package br.com.example.payments.domain.ports.input;

import br.com.example.payments.domain.model.CalculatePaymentOptionsRequest;
import br.com.example.payments.domain.model.CalculatePaymentOptionsResponse;

public interface CalculatePaymentsOptionsInput {

    CalculatePaymentOptionsResponse calculate(CalculatePaymentOptionsRequest request);
}
