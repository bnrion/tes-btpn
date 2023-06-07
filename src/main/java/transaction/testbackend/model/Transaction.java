package transaction.testbackend.model;

import lombok.Data;

@Data
public class Transaction {
    Integer AccountId;
    String TransactionDate;
    String Description;
    String DebitCreditStatus;
    Integer Amount;
}
