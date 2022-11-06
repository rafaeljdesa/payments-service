package br.com.example.payments.application.adapter;

import br.com.example.payments.domain.model.CalculatePaymentOptionsRequest;
import br.com.example.payments.domain.model.CalculatePaymentOptionsResponse;
import br.com.example.payments.domain.ports.input.CalculatePaymentsOptionsInput;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentsRestAdapter {

    private final CalculatePaymentsOptionsInput calculatePaymentsOptionsInput;

    public PaymentsRestAdapter(CalculatePaymentsOptionsInput calculatePaymentsOptionsInput) {
        this.calculatePaymentsOptionsInput = calculatePaymentsOptionsInput;
    }

    @PostMapping("/options/calculate")
    public CalculatePaymentOptionsResponse calculatePaymentOptions(@RequestBody CalculatePaymentOptionsRequest request) {
        return calculatePaymentsOptionsInput.calculate(request);
    }
}
