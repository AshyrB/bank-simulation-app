package com.cydeo.service.impl;

import com.cydeo.model.Account;
import com.cydeo.model.Transaction;
import com.cydeo.service.TransactionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creationDate, String message) {
        /*
         * If sender or receiver is null?
         * if sender and receiver is the same account?
         * if sender has enough balance to make transfer?
         * if both accounts are checking, if not, one of them saving, it needs to be same userID
         */
        validateAccount(sender,receiver);
        //make Transfer


        return null;
    }

    private void validateAccount(Account sender, Account receiver){
        /*
            - if any of the account is null
            - if account ids are the same(same account)
            - if the account exist in the database (repository)
         */
    }


    @Override
    public List<Transaction> findAllTransaction() {
        return null;
    }
}
