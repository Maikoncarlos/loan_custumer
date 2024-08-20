package loan_customer.controller;

import loan_customer.controller.dto.CustomerRequest;
import loan_customer.controller.dto.LoanCustomerResponse;
import loan_customer.service.ILoanMatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/loan")
public class LoanMatchController {

    private final ILoanMatchService service;

    public LoanMatchController(ILoanMatchService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoanCustomerResponse> loanMatch(@RequestBody CustomerRequest custumer) {

        var response = service.checkLoanCustomer(custumer);

        return ResponseEntity.ok(response);
    }
}
