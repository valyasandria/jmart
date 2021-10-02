package valyaJmartPK;

import java.util.Date;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public int paymentId;
    public Date date ;
    public String desc;
    Complaint(int id, Date date, String desc)
    {
        super(id);
    	java.util.Date myDate = new java.util.Date();
        this.date = date;
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
}
