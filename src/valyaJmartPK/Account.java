package valyaJmartPK;
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
    public static String REGEX_EMAIL = "^[A-Z0-9.&_*~]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static String REGEX_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    public double balance;
    public String name;
    public String email;
    public String password;

    public Account(String name, String email, String password)
    {

        this.name = name;
        this.email = email;
        this.password = password;

    }

    public boolean validate(String email)
    {
        //validasi email
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = emailPattern.matcher(this.email);

        //validasi password
        Pattern passPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher matchPass = passPattern.matcher(password);

        return matcher.find() && matchPass.find();
    }

}
