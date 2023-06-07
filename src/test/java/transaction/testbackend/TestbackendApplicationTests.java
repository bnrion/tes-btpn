package transaction.testbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import transaction.testbackend.model.Account;
import transaction.testbackend.model.Transaction;
import transaction.testbackend.utils.DatabaseUtils;

import java.sql.SQLException;

@SpringBootTest
class TestbackendApplicationTests {

    @Test
    void contextLoads() throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setAccountId(1);
        transaction.setAmount(100000);
        transaction.setDescription("Beli Pulsa");
        transaction.setDebitCreditStatus("D");
        transaction.setTransactionDate("2023-05-08");
        DatabaseUtils.callStoredProcedure("usp_create_transaction",transaction.getAccountId(),transaction.getTransactionDate(),transaction.getDescription(),transaction.getDebitCreditStatus(),transaction.getAmount());
    }

}
