package valyaJmartPK;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    
    public Date date ;
    public String desc;

    Complaint(int id,String desc)
    {
        super(id);
    	Date current_date = new Date();
        SimpleDateFormat complaintDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = complaintDate.format(current_date);
        
        this.desc = desc;
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
    public String toString()
    {
        return ("Complaint{date= " + date + "," + "desc= " + this.desc + "}");
    }
}
