package transaction.testbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import transaction.testbackend.dao.AccountDAO;
import transaction.testbackend.dao.TransactionDAO;
import transaction.testbackend.model.Account;
import transaction.testbackend.model.FilterTransaction;
import transaction.testbackend.model.PointScenario;
import transaction.testbackend.model.Transaction;

import java.sql.SQLException;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionDAO trxdao;

    @PostMapping("/usp_point_scenario")
    public String UspPointScenario(@RequestBody PointScenario pointScenario) throws SQLException {
        return trxdao.UspPointScenario(pointScenario);
    }

    @PostMapping("/usp_trx")
    public String UspTrx(@RequestBody Transaction trx) throws SQLException {
        return trxdao.UspTransaction(trx);
    }
    @GetMapping("/get_trx")
    public String getTransaction() throws SQLException {
        return trxdao.GetTransactionData();
    }


    @GetMapping("/filter_trx")
    public String FilterTransaction(@RequestParam FilterTransaction filterTransaction) throws SQLException {

        if (filterTransaction != null ){
            System.out.println(true);
        }
        else System.out.println(false);

        System.out.println(filterTransaction.getAccountID());
        return trxdao.FilterTransaction(filterTransaction);
    }

    @GetMapping("/get_trx_point")
    public String GetTransactionPoint() throws SQLException {
        return trxdao.GetTransactionPoint();
    }
}
