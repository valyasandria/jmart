package com.valyaJmartPK;
import com.valyaJmartPK.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    public static String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";

    public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;

    public Account(String name, String email, String password, double balance)
    {

        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;

    }

    public boolean validate(String email, String password)
    {
        //validasi email
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = emailPattern.matcher(email);

        //validasi password
        Pattern passPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher matchPass = passPattern.matcher(password);

        return matcher.find() && matchPass.find();
    }

}
