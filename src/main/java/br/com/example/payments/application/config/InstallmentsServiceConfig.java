package br.com.example.payments.application.config;

import br.com.example.payments.domain.ports.input.CalculatePaymentsOptionsInput;
import br.com.example.payments.domain.service.CalculatePaymentsOptionsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstallmentsServiceConfig {

    @Bean
    public CalculatePaymentsOptionsInput calculatePaymentsOptionsInput() {
        return new CalculatePaymentsOptionsService();
    }
}
