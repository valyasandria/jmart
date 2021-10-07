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
    public String REGEX_EMAIL;
    public String REGEX_PASSWORD;
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

    public boolean validateEmail(String email)
    {
        //email
        REGEX_EMAIL = "^[A-Z0-9.&_*~]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL, Pattern.CASE_INSENSITIVE);

        if (email == null)
        {
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();

    }

    public boolean validatePass(String password)
    {
        REGEX_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        Pattern passPattern = Pattern.compile(REGEX_PASSWORD);
        //password
        if (password == null)
        {
            return false;
        }
        Matcher matchPass = passPattern.matcher(password);
        return matchPass.matches();
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
