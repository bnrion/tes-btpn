package transaction.testbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transaction.testbackend.dao.AccountDAO;
import transaction.testbackend.model.Account;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountDAO accdao;



    @PostMapping("/usp_acc")
    public String UspAccount(@RequestBody Account account) throws SQLException {
        System.out.println(account.getAction());
       return accdao.Uspaccount(account);
    }
}
