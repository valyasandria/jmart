package com.valyaJmartPK.controller;

import com.valyaJmartPK.Account;
import com.valyaJmartPK.Algorithm;
import com.valyaJmartPK.Store;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public abstract class AccountController implements BasicGetController<Account> {

    public static String REGEX_EMAIL = "^[A-Z0-9.&_*~]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static String REGEX_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "D:/Praktikum OOP/jmart/account.json")
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }


    @GetMapping
    String index() {
        return "account page";
    }

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password,
                    @RequestParam double balance
            )
    {
        String passToHash = password;
        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passToHash.getBytes());

            byte[] bytes = md.digest();

            //convert to hex
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();

        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Matcher matcher = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matchPass = REGEX_PATTERN_PASSWORD.matcher(password);

        if(matcher.find() && matchPass.find() && password.equals(generatedPassword))
        {
            return new Account(name, email, password, 0);
        }

        else{
            return null;
        }

    }

    @PostMapping ("/register")
    Account Register

            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password

            )

    {
        String passwordToHash = password;
        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());

            byte[] bytes = md.digest();

            //convert to hex
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        password = generatedPassword;

        if (name != null) {
            return new Account(name, email, password, 0);
        }
        else {
            return null;
        }
    }

    @PostMapping ("/{id}/registerStore")
    Account registerStore(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    )

    {
        Account myAcc = Algorithm.<Account>find(accountTable, e -> e.id == id);
        if (myAcc == null || myAcc.store != null)
        {
            return null;
        }

        myAcc.store = new Store(name, address, phoneNumber,0);
        return myAcc;
    }

    @PostMapping ("/{id}/topUp")
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance

            )
    {
        Account myAcc = Algorithm.<Account>find(accountTable, e -> e.id == id);
        if (myAcc == null)
        {
            balance += balance;
            return true;
        }
        else
        {
            return false;
        }
    }
}