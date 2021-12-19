package com.valyaJmartPK.controller;

import com.valyaJmartPK.Account;
import com.valyaJmartPK.Algorithm;
import com.valyaJmartPK.Store;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/**
 * Used to register new account and login
 * @author Valya Sandria Akiela
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {

    public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "D://Praktikum OOP/jmart/account.json")
    public static JsonTable<Account> accountTable;

    @Override
    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    @GetMapping
    String index() {
        return "account page";
    }

    //login account
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        Account account = Algorithm.<Account>find(accountTable, (e)->e.email.equals(email));

        String generatedPassword = null;

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5"); //encryption password
            md.update(password.getBytes()); //add password bytes to digest
            byte[] bytes = md.digest(); //get hash's bytes

            //convert to hexadecimal
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        if (account != null && account.password.equals(generatedPassword))
        {
            return account;
        }
        else
        {
            return null;
        }
    }

    //register new account
    @RequestMapping  (value = "/register", method = RequestMethod.POST)
    Account Register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )

    {
        if(name.isBlank() || !REGEX_PATTERN_EMAIL.matcher(email).matches() || !REGEX_PATTERN_PASSWORD.matcher(password).matches() || Algorithm.<Account>exist(accountTable, e->e.email.equals(email)))
        {
            return null;
        }
        else{

            String generatedPassword = null;

            try
            {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < bytes.length; i++)
                {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }

                generatedPassword = sb.toString();
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            Account newAccount = new Account(name, email, generatedPassword,0);
            accountTable.add(newAccount);
            return newAccount;
        }
    }

    //register account's store
    @RequestMapping(value = "/{id}/registerStore", method = RequestMethod.POST)
     Store registerStore
            (
                @PathVariable int id,
                @RequestParam String name,
                @RequestParam String address,
                @RequestParam String phoneNumber
            )

    {
        Account account = Algorithm.<Account>find(accountTable, e -> e.id == id);
        if (account == null || account.store != null)
        {
            return null;
        }

        account.store = new Store(name, address, phoneNumber);
        return account.store;
    }

    //top up account's balance
    @RequestMapping(value = "/{id}/topUp", method = RequestMethod.POST)
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account account = Algorithm.<Account>find(accountTable, e -> e.id == id);
        if (account == null)
        {
            return false;
        }
        else
        {
            account.balance += balance;
            return true;
        }
    }
}