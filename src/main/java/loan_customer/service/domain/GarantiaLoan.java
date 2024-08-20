package loan_customer.service.domain;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanResponse;
import loan_customer.service.LoanType;

import java.util.List;

public class GarantiaLoan extends CheckLoanCustomer {

    public GarantiaLoan(CheckLoanCustomer next) {
        super(next);
    }

    @Override
    public List<LoanResponse> check(List<LoanResponse> loans, CustomerRequest request) {
        if ((request.isMinorOrEqual3k() && request.isBetweenAge18And30AndLocationSP())
                || (request.isBigger3kAndMinor5k() && request.isLocationSP())
                || (request.isBiggerOrEqual5k()) && request.isBetweenAge18And30()) {

            LoanResponse loan = new LoanResponse(LoanType.GARANTIA_LOAN.getType(), LoanType.GARANTIA_LOAN.getTaxes());
            loans.add(loan);
        }
        return next.check(loans, request);
    }
}
