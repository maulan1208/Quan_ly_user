package com.example.finalexamro37.service.Account;

import com.example.finalexamro37.entity.Account;
import com.example.finalexamro37.form.Account.CreatingAccountForm;
import com.example.finalexamro37.form.Account.UpdatingAccountForm;
import com.example.finalexamro37.repository.IAccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void createAccount(CreatingAccountForm form) {
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Account.class);
        if (typeMap == null) { // if not already added
            // skip field
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        Account account = modelMapper.map(form, Account.class);
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(UpdatingAccountForm form) {
        Account account = modelMapper.map(form, Account.class);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

}
