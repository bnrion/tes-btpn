package transaction.testbackend.dao.impl;

import transaction.testbackend.dao.AccountDAO;
import transaction.testbackend.model.Account;
import transaction.testbackend.utils.DatabaseUtils;

import java.sql.SQLException;

public class AccountDAOimpl implements AccountDAO {
    @Override
    public String Uspaccount(Account account) throws SQLException {
        return DatabaseUtils.callStoredProcedure("usp_account",account.getAction(),account.getId(),account.getName());
    }
}
