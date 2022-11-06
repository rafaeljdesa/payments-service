package br.com.example.payments.domain.model.interests;

import br.com.example.payments.domain.exception.InvalidQuantityOfInstallmentsException;

public class InterestsFactory {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int TWELVE = 12;

    public static Interests create(int quantityOfInstallments) {
        if (quantityOfInstallments == ONE) {
            return new InterestsToOneInstallment();
        }

        if (quantityOfInstallments == TWO || quantityOfInstallments == THREE) {
            return new InterestsFromTwoToThreeInstallments();
        }

        if (quantityOfInstallments >= FOUR && quantityOfInstallments <= SIX) {
            return new InterestsFromFourToSixInstallments();
        }

        if (quantityOfInstallments >= SEVEN && quantityOfInstallments <= TWELVE) {
            return new InterestsFromSevenToTwelveInstallments();
        }

        throw new InvalidQuantityOfInstallmentsException();
    }

}
