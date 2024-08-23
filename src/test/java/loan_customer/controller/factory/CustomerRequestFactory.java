package loan_customer.controller.factory;

import loan_customer.controller.dto.CustomerRequest;

public class CustomerRequestFactory {

    public static CustomerRequest buildOnlyLoanPersonal(int age, String location, Double income) {
        return new CustomerRequest("Ericka", "12345678910", age, location, income);
    }
}
