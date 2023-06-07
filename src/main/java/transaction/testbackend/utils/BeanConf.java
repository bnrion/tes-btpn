package transaction.testbackend.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import transaction.testbackend.dao.AccountDAO;
import transaction.testbackend.dao.TransactionDAO;
import transaction.testbackend.dao.impl.AccountDAOimpl;
import transaction.testbackend.dao.impl.TransactionDAOimpl;

@Configuration
public class BeanConf {
    @Bean
    public AccountDAO accountDAO(){
        return new AccountDAOimpl();
    }
    @Bean
    public TransactionDAO transactionDao(){
        return new TransactionDAOimpl();
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("transaction.testbackend")).build();
//    }
}
