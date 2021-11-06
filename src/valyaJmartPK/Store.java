package valyaJmartPK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    public String REGEX_PHONE;
    public String REGEX_NAME;
    public String address;
    public double balance;
    public String name;
    public String phoneNumber;
    
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address; 
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String toString()
    {
        return ("Name: " + this.name + "\naddress: " + this.address + "\nphoneNumber: " + this.phoneNumber);
    }

    public boolean validate(){
        Pattern pattern = Pattern.compile("^[0-9] {9,12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean matchFound = matcher.find();
        String result = matchFound ? "FOUND!" : "NOT FOUND!";
        if (result == "FOUND!")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
