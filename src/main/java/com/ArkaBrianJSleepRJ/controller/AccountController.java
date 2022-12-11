package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.Account;
import com.ArkaBrianJSleepRJ.Algorithm;
import com.ArkaBrianJSleepRJ.Renter;
import com.ArkaBrianJSleepRJ.dbjson.JsonAutowired;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class,
            filepath = "C:\\Users\\Arka Brian\\Documents\\Arka\\Kuliah\\UI\\Semester 3\\OOP\\Praktikum\\PraktikumCode\\JSleep\\src\\main\\java\\com\\json\\account.json")
    public static JsonTable<Account> accountTable;
    final public static String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    final public static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @GetMapping
    String index() {
        return "account page";
    }

    /**
     * Registers a new account with the given name, email, and password.
     * @param name the name of the user
     * @param email the email of the user
     * @param password the password of the user
     * @return the registered Account object, or null if the registration failed
     * @throws NoSuchAlgorithmException if the hashing algorithm specified in the method cannot be found
     */
    @PostMapping("/register")
    Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException {
        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();

        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        if (findAccount == null && matchEmail && matchFoundPassword) {
            final String generatedPassword;
            generatedPassword = hash(password);
            Account account = new Account(name, email, generatedPassword);
            accountTable.add(account);
            return account;
        } return null;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    public Account login(@RequestParam String email, @RequestParam String password) throws NoSuchAlgorithmException {
        for(Account account : getJsonTable()){
            String hash = hash(password);
            if(account.email.equals(email) && account.password.equals(hash)){
                return account;
            }
        }
        return null;
    }

    @PostMapping("{id}/topUp")
    public boolean topUp(@PathVariable int id, @RequestParam double balance){
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(account == null) return false;
        account.balance += balance;
        return true;
    }

    @PostMapping("{id}/registerRenter")
    public Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        for(Account account : accountTable){
            if(account.id == id){
                Renter renter = new Renter(username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }

    /**
     * Hashes the given password using the MD5 algorithm.
     * @param password the password to hash
     * @return the hashed password
     * @throws NoSuchAlgorithmException if the MD5 algorithm is not available
     */
    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
