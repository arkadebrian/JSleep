package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.Account;
import com.ArkaBrianJSleepRJ.Algorithm;
import com.ArkaBrianJSleepRJ.Renter;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    JsonTable<Account> accountTable;
    final public static String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    final public static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @GetMapping
    String index() {
        return "account page";
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if(!name.isBlank()){
            if(REGEX_PATTERN_EMAIL.matcher(email).matches()){
                if(REGEX_PATTERN_PASSWORD.matcher(password).matches()){
                    Account account = new Account(name, email, password);
                    accountTable.add(account);
                    return account;
                }
            }
        }
        return null;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    public Account login(@RequestParam String email, @RequestParam String password){
        for(Account account : getJsonTable()){
            if(account.email.equals(email) && account.password.equals(password)){
                return account;
            }
        }
        return null;
    }

    @PostMapping("{id}/topUp")
    public boolean topUp(@PathVariable int id, @RequestParam double balance){
        Account account = accountTable.get(id);
        if(account == null) return false;
        account.balance += balance;
        return true;
    }

    @PostMapping("{id}/registerRenter")
    public Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address, @RequestParam String phoneNumber){
        for(Account account : accountTable){
            if(account.id == id){
                Renter renter = new Renter(username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }


}
