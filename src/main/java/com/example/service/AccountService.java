package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.ConflictException;
import com.example.exception.InvalidAccountException;
import com.example.exception.UnauthorizedException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }
    /*
     * The registration will be successful if and only if the username is not blank, the password is at least 4 characters long, and an Account with that username does not already exist.
     * If all these conditions are met, return the created Account, including its accountId.
     * The new account will be persisted to the database.
     * 
     * @throws
     * ConflictException - If the registration is not successful due to a duplicate username
     * InvalidAccountException - If the registration is not successful for some other reason
     */
    public Account register(Account account) {
        validateAccountFormat(account);
        if (repository.findByUsername(account.getUsername()).size()>0) throw new ConflictException("Account Already Exists");
        return repository.save(account);
    }
    public void validateAccountFormat(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        if (username==null || username.length()==0) throw new InvalidAccountException("Account Username not be empty. Value = "+username);
        if (password==null || password.length()<4) throw new InvalidAccountException("Account Password must be at least 4 characters. Value = "+password);
    }

    /*
     * 
     *
     * The login will match if and only if the username and password match a real account existing on the database.
     * @return - the matching Account.
     * 
     * @throws UnauthorizedException - If the login is not successful
     *
     */
    public Account getAccountMatchingLogin(Account account) {
        List<Account> matching = repository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (matching.size()==0) throw new UnauthorizedException("No account with specified credentials exists.");
        return matching.get(0);
    }
}
