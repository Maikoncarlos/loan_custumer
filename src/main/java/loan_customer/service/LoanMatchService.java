package loan_customer.service;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanCustomerResponse;
import loan_customer.controller.dto.LoanResponse;
import loan_customer.service.domain.ConsignadoLoan;
import loan_customer.service.domain.GarantiaLoan;
import loan_customer.service.domain.PersonalLoan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanMatchService implements ILoanMatchService {

    @Override
    public LoanCustomerResponse checkLoanCustomer(CustomerRequest request) {

        var resultLoanMatch = new PersonalLoan(new GarantiaLoan(new ConsignadoLoan()));

        List<LoanResponse> loanList = new ArrayList<>();

        List<LoanResponse> loans = resultLoanMatch.check(loanList, request);
        return new LoanCustomerResponse(request.name(), loans);
    }
}
