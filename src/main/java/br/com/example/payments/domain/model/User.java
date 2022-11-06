package br.com.example.payments.domain.model;

public class User {

    private static final int AGE_FOR_DISCOUNT = 60;

    public User(String firstName,
                String lastName,
                int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {
        this.firstName = null;
        this.lastName = null;
        this.age = 0;
    }

    private final String firstName;
    private final String lastName;
    private final int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isEnabledForDiscount() {
        return age > AGE_FOR_DISCOUNT;
    }
}
