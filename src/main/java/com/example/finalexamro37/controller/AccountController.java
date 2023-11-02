package com.example.finalexamro37.controller;

import com.example.finalexamro37.dto.AccountDTO;
import com.example.finalexamro37.entity.Account;
import com.example.finalexamro37.form.Account.CreatingAccountForm;
import com.example.finalexamro37.form.Account.UpdatingAccountForm;
import com.example.finalexamro37.service.Account.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/accounts")
@Validated
@CrossOrigin(origins = "http://127.0.0.1:5502/")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping()
    public List<AccountDTO> getAllAccount(){
        List<Account> accounts = accountService.getAllAccounts();
        return accounts.stream().map(account -> modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Account getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @PostMapping()
    public void createAccount(@RequestBody CreatingAccountForm form){
        accountService.createAccount(form);
    }

    @PutMapping("{id}")
    public void updateAccountById(@PathVariable int id, @RequestBody UpdatingAccountForm form){
        form.setId(id);
        accountService.updateAccount(form);
    }

    @DeleteMapping("{id}")
    public void deleteAccount (@PathVariable int id){
        accountService.deleteAccount(id);
    }
}
