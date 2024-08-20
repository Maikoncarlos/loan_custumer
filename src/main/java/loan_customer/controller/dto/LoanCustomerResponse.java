package loan_customer.controller.dto;

import java.util.List;

public record LoanCustomerResponse(String customer, List<LoanResponse> loans) {

}
