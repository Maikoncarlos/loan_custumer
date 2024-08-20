package loan_customer.service.domain;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CheckLoanCustomer {

    protected CheckLoanCustomer next;

    public CheckLoanCustomer(CheckLoanCustomer checkLoanCustomer) {
        this.next = checkLoanCustomer;
    }

    public abstract List<LoanResponse> check(List<LoanResponse> loans, CustomerRequest request);
}
