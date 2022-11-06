package br.com.example.payments.domain.service;

import br.com.example.payments.domain.model.*;
import br.com.example.payments.domain.model.discount.Discount;
import br.com.example.payments.domain.model.discount.DiscountFactory;
import br.com.example.payments.domain.model.installments.NumberOfInstallments;
import br.com.example.payments.domain.model.installments.NumberOfInstallmentsFactory;
import br.com.example.payments.domain.model.interests.Interests;
import br.com.example.payments.domain.model.interests.InterestsFactory;
import br.com.example.payments.domain.ports.input.CalculatePaymentsOptionsInput;

import java.util.ArrayList;
import java.util.List;

public class CalculatePaymentsOptionsService implements CalculatePaymentsOptionsInput {

    @Override
    public CalculatePaymentOptionsResponse calculate(CalculatePaymentOptionsRequest request) {
        NumberOfInstallments numberOfInstallments = getAvailableNumberOfInstallments(request);
        List<PaymentOption> paymentOptions = getPaymentOptions(request, numberOfInstallments);
        return CalculatePaymentOptionsFactory.create(paymentOptions);
    }

    private NumberOfInstallments getAvailableNumberOfInstallments(CalculatePaymentOptionsRequest request) {
        return NumberOfInstallmentsFactory.create(request.getShoppingCart());
    }

    private List<PaymentOption> getPaymentOptions(CalculatePaymentOptionsRequest request,
                                                  NumberOfInstallments numberOfInstallments) {
        List<PaymentOption> paymentOptions = new ArrayList<>();
        for (int installment = 1; installment <= numberOfInstallments.get(); installment++) {
            Interests interests = InterestsFactory.create(installment);
            List<Discount> discounts = DiscountFactory.create(request.getUser(), request.getShoppingCart(), installment);
            CalculatePaymentOptions option = new CalculatePaymentOptions(
                    request.getShoppingCart().getAmount(),
                    installment,
                    interests,
                    discounts
            );
            paymentOptions.add(new PaymentOption(option.getNumberOfInstallments(), option.getAmount()));
        }
        return paymentOptions;
    }
}
