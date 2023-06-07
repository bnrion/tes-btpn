package transaction.testbackend.dao.impl;

import transaction.testbackend.dao.TransactionDAO;
import transaction.testbackend.model.FilterTransaction;
import transaction.testbackend.model.PointScenario;
import transaction.testbackend.model.Transaction;
import transaction.testbackend.utils.DatabaseUtils;

import java.sql.SQLException;

public class TransactionDAOimpl implements TransactionDAO {
    @Override
    public String UspTransaction(Transaction transaction) throws SQLException {
        return DatabaseUtils.callStoredProcedure("usp_create_transaction",transaction.getAccountId(),transaction.getTransactionDate(),transaction.getDescription(),transaction.getDebitCreditStatus(),transaction.getAmount());
    }

    @Override
    public String UspPointScenario(PointScenario pointScenario) throws SQLException {
        return DatabaseUtils.callStoredProcedure("usp_point_scenario",pointScenario.getAction(),pointScenario.getId(),pointScenario.getTransaction_type(),pointScenario.getAmount_range_from()
        ,pointScenario.getAmount_range_to(),pointScenario.getPoint_per_unit(),pointScenario.getMultiple_of()
        );
    }

    @Override
    public String GetTransactionData() throws SQLException {
        return DatabaseUtils.callStoredProcedure("GetTransactionData");
    }

    @Override
    public String FilterTransaction(FilterTransaction filterTransaction) throws SQLException {
        return DatabaseUtils.callStoredProcedure("FilterTransaction",filterTransaction.getAccountID(),filterTransaction.getStartDate(),filterTransaction.getStartDate());

    }

    @Override
    public String GetTransactionPoint() throws SQLException {
        return DatabaseUtils.callStoredProcedure("get_transaction_points");
    }

}
