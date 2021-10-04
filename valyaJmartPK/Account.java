package valyaJmartPK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    final String REGEX_EMAIL;
    final String REGEX_PASSWORD;
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean read(String content)
    {
        return true;
    }


    public boolean validate()
    {
        //email
        Pattern emailPattern = Pattern.compile("^[A-Z0-9.&_*~]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        boolean emailFound = matcher.find();
        String result = matchFound ? "FOUND!" : "NOT FOUND!";
        if (result == "FOUND!")
        {
            return true;
        }
        else
        {
            return false;
        }
        
        //password
        Pattern passPattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
        Matcher matchPass = passPattern.matcher(password);
        boolean passFound = matchPass.find();
        String matchFound;
        String res = matchFound ? "FOUND!" : "NOT FOUND!";
        if (res == "FOUND!")
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public Object write()
    {
        return null;
    }
    @Override
    public String toString()
    {
        return("Name: " + this.name + "\nemail: " + this.email + "\npassword: " + this.password);
    }
}
