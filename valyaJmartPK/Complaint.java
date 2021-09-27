package valyaJmartPK;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public int paymentId;
    public String date = "14/02/2022";
    public String desc;
    Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
    }
    @Override
    public boolean read(String content)
    {
        return false;
    }
}
