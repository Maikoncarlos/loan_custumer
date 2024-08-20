package loan_customer.service;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanCustomerResponse;

public interface ILoanMatchService {

    LoanCustomerResponse checkLoanCustomer(CustomerRequest request);
}
