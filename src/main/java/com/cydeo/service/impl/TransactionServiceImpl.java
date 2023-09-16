package com.cydeo.service.impl;


import com.cydeo.enums.AccountType;
import com.cydeo.exception.AccountOwnershipException;
import com.cydeo.exception.BadRequestException;
import com.cydeo.model.Account;
import com.cydeo.model.Transaction;
import com.cydeo.repository.AccountRepository;
import com.cydeo.service.TransactionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date creationDate, String message) {
        /*
         * If sender or receiver is null?
         * if sender and receiver is the same account?
         * if sender has enough balance to make transfer?
         * if both accounts are checking, if not, one of them saving, it needs to be same userID
         */
        validateAccount(sender,receiver);
        checkAccountOwnership(sender,receiver);



        //make Transfer


        return null;
    }

    private void checkAccountOwnership(Account sender, Account receiver) {
        /*
            write an if statement that checks if one of the account is saving,
            and user of sender or receiver is not the same, throw AccountOwnershipException
         */
        if(
                sender.getAccountType().equals(AccountType.SAVING)||receiver.getAccountType().equals(AccountType.SAVING)
                && (!sender.getUserId().equals(receiver.getUserId()))){
            throw new AccountOwnershipException("If one of the account is saving, user must be the same for sender and receiver");
        }


    }

    private void validateAccount(Account sender, Account receiver){
        /*
            - if any of the account is null
            - if account ids are the same(same account)
            - if the account exist in the database (repository)
         */

        if(sender==null||receiver==null){
           throw new BadRequestException("Sender or Receiver cannot be null");

        }

        // if accounts are the same throw BadRequestException with saying accounts needs to be different
        if(sender.getId().equals(receiver.getId())){
            throw new BadRequestException("Accounts needs to be different than receiver account");
        }

        findAccountByID(sender.getId());
        findAccountByID(receiver.getId());

    }

    private void findAccountByID(UUID id) {

        accountRepository.findById(id);

    }


    @Override
    public List<Transaction> findAllTransaction() {
        return null;
    }
}
