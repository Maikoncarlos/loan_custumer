package loan_customer.service;

public enum LoanType {

    PERSONAL_LOAN("personal", 4),

    GARANTIA_LOAN("garantia", 3),

    CONSIGNADO_LOAN("consignado", 2);

    private final String type;

    public String getType() {
        return type;
    }

    public int getTaxes() {
        return taxes;
    }

    private final int taxes;


    LoanType(String type, int taxes) {
        this.type = type;
        this.taxes = taxes;
    }
}
