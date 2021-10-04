package valyaJmartPK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    public String REGEX_PHONE;
    public String REGEX_NAME;
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address; 
        this.phoneNumber = phoneNumber;
    }
    public Store(Account account, String name, String address, String phoneNumber)
    {
     super(account.id);
     this.name = name;
     this.address = address; 
     this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean read(String content)
    {
        return true;
    }
    @Override
    public Object write()
    {
        return null;
    }

    
    
    public boolean validate(){
        Pattern pattern = Pattern.compile("^[0-9] {9,12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean matchFound = matcher.find();
        String result = matchFound ? "FOUND!" : "NOT FOUND!";
        if (result == "FOUND!"){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString()
    {
        return ("Name: " + this.name + "\naddress: " + this.address + "\nphoneNumber: " + this.phoneNumber);
    }
}
