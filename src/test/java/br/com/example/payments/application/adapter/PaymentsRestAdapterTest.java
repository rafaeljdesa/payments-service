package br.com.example.payments.application.adapter;

import br.com.example.payments.domain.model.CalculatePaymentOptionsRequest;
import br.com.example.payments.domain.model.CalculatePaymentOptionsResponse;
import br.com.example.payments.domain.model.PaymentOption;
import br.com.example.payments.domain.model.PaymentOptions;
import br.com.example.payments.domain.ports.input.CalculatePaymentsOptionsInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PaymentsRestAdapterTest {

    @Mock
    private CalculatePaymentsOptionsInput calculatePaymentsOptionsInput;

    @InjectMocks
    private PaymentsRestAdapter paymentsRestAdapter;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(paymentsRestAdapter).build();
    }

    @Test
    public void should_return_payment_options_when_success() throws Exception {
        when(calculatePaymentsOptionsInput.calculate(any(CalculatePaymentOptionsRequest.class))).thenReturn(getResponse());

        this.mockMvc.perform(post("/payments/options/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getContentBody()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paymentOptions").exists())
                .andExpect(jsonPath("$.paymentOptions.paymentOptions").exists())
                .andExpect(jsonPath("$.paymentOptions.paymentOptions[0].numberOfInstallments").value(1))
                .andExpect(jsonPath("$.paymentOptions.paymentOptions[0].amount").value(2925.00))
                .andExpect(jsonPath("$.paymentOptions.paymentOptions[1].numberOfInstallments").value(2))
                .andExpect(jsonPath("$.paymentOptions.paymentOptions[1].amount").value(1515))
                .andExpect(jsonPath("$.paymentOptions.paymentOptions[2].numberOfInstallments").value(3))
                .andExpect(jsonPath("$.paymentOptions.paymentOptions[2].amount").value(1010.00));
    }

    @Test
    public void should_return_bad_request_when_body_is_empty() throws Exception {
        this.mockMvc.perform(post("/payments/options/calculate"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    private CalculatePaymentOptionsResponse getResponse() {
        PaymentOption paymentOption1 = new PaymentOption(1, BigDecimal.valueOf(2925.00));
        PaymentOption paymentOption2 = new PaymentOption(2, BigDecimal.valueOf(1515.00));
        PaymentOption paymentOption3 = new PaymentOption(3, BigDecimal.valueOf(1010.00));
        PaymentOptions paymentOptions = new PaymentOptions(List.of(paymentOption1, paymentOption2, paymentOption3));
        return new CalculatePaymentOptionsResponse(paymentOptions);
    }

    private String getContentBody() {
        return """
                {
                  "user": {
                    "firstName": "Test",
                    "lastName": "Test",
                    "age": 30
                  },
                  "shoppingCart": {
                    "items": [
                      {
                        "product": {
                          "category": "DECOR",
                          "title": "Product ABC",
                          "price": 3000.00
                        },
                        "quantity": 1
                      }
                    ]
                  }
                }
                """;
    }
}