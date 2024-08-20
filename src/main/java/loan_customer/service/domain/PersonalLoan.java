package loan_customer.service.domain;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanResponse;
import loan_customer.service.LoanType;

import java.util.List;

public class PersonalLoan extends CheckLoanCustomer {

    public PersonalLoan(CheckLoanCustomer next) {
        super(next);
    }

    @Override
    public List<LoanResponse> check(List<LoanResponse> loans, CustomerRequest request) {
        if (request.isBiggerOrEqualAge18()) {
            var loansResponse = new LoanResponse(LoanType.PERSONAL_LOAN.getType(), LoanType.PERSONAL_LOAN.getTaxes());
            loans.add(loansResponse);
        }
        return next.check(loans, request);
    }

}
