package com.valyaJmartPK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Register new store
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class Store
{
    public static String REGEX_PHONE = "^(/d{9,12})$";
    public static String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";

    public String name;
    public String address;
    public String phoneNumber;

    //store detail
    public Store(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address; 
        this.phoneNumber = phoneNumber;
    }

    public String toString()
    {
        return ("Name: " + this.name + "\naddress: " + this.address + "\nphoneNumber: " + this.phoneNumber);
    }

    public boolean validate()
    {
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(phoneNumber);
        Pattern pattern2 = Pattern.compile(REGEX_NAME);
        Matcher matcher2 = pattern2.matcher(name);
        return matcher.find() && matcher2.find();
    }
}
