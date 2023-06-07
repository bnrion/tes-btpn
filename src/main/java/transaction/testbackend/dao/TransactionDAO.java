package transaction.testbackend.dao;

import transaction.testbackend.model.Account;
import transaction.testbackend.model.FilterTransaction;
import transaction.testbackend.model.PointScenario;
import transaction.testbackend.model.Transaction;

import java.sql.SQLException;

public interface TransactionDAO {
    String UspTransaction(Transaction account) throws SQLException;
    String UspPointScenario(PointScenario pointScenario) throws SQLException;
    String GetTransactionData() throws SQLException;
    String FilterTransaction(FilterTransaction filterTransaction) throws SQLException;
    String GetTransactionPoint() throws SQLException;
}
