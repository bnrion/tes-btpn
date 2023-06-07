package transaction.testbackend.dao;

import transaction.testbackend.model.Account;

import java.sql.SQLException;

public interface AccountDAO {
     String Uspaccount(Account account) throws SQLException;
}
