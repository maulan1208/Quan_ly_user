package com.example.finalexamro37.service.Account;

import com.example.finalexamro37.entity.Account;
import com.example.finalexamro37.form.Account.CreatingAccountForm;
import com.example.finalexamro37.form.Account.UpdatingAccountForm;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccounts();

    Account getAccountById(int id);
    void createAccount(CreatingAccountForm form);
    void updateAccount(UpdatingAccountForm form);
    void deleteAccount(int id);
}
