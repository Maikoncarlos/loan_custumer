package loan_customer.controller.dto;

public record CustomerRequest(String name,
                              String cpf,
                              int age,
                              String location,
                              Double income) {

    public boolean isMinorOrEqual3k() {
        return income <= 3000;
    }

    public boolean isBigger3kAndMinor5k() {
        return income > 3000 && income < 5000;
    }

    public boolean isBiggerOrEqual5k() {
        return income >= 5000;
    }

    public boolean isBetweenAge18And30() {
        return isBiggerOrEqualAge18() && age < 30;
    }

    public boolean isBiggerOrEqualAge18() {
        return age >= 18;
    }

    public boolean isLocationSP() {
        return location.equalsIgnoreCase("SP");
    }

    public boolean isBetweenAge18And30AndLocationSP() {
        return isBetweenAge18And30() && isLocationSP();
    }

}
