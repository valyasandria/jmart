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
        Pattern pattern = Pattern.compile("^(/d{9,12})$");
        Matcher matcher = pattern.matcher(this.phoneNumber);
        Pattern pattern2 = Pattern.compile("^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$");
        Matcher matcher2 = pattern2.matcher(this.name);
        return matcher.find() && matcher2.find();
    }
}
