package loan_customer.service.domain;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanResponse;
import loan_customer.service.LoanType;

import java.util.List;

public class ConsignadoLoan extends CheckLoanCustomer {
    public ConsignadoLoan() {
        super(null);
    }

    @Override
    public List<LoanResponse> check(List<LoanResponse> loans, CustomerRequest request) {
        if (request.isBiggerOrEqualAge18() && request.isBiggerOrEqual5k()) {
            LoanResponse loanResponse = new LoanResponse(LoanType.CONSIGNADO_LOAN.getType(), LoanType.CONSIGNADO_LOAN.getTaxes());
            loans.add(loanResponse);
        }
        return loans;
    }
}
