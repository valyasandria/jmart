package valyaJmartPK;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{
    public SimpleDateFormat ESTIMATION_FORMAT;
    public Plan INSTANT;
    public Plan KARGO;
    public Plan NEXT_DAY;
    public Plan REGULER;
    public Plan SAME_DAY;

   public String address;
   public int cost;
   public byte plan;
   public String receipt;

    public Shipment(String address, int cost, byte plan, String receipt)
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival(Date reference)
    {
        Calendar cal = Calendar.getInstance();
        if(this.plan == 1<<0|| this.plan == 1<<1)
        {
            return ESTIMATION_FORMAT.format(reference.getTime());
        }

        else if(this.plan == 1<<2)
        {
            cal.setTime(reference);
            cal.add(Calendar.DATE,1);
            return ESTIMATION_FORMAT.format(cal);
        }

        else if(this.plan == 1<<3)
        {
            cal.setTime(reference);
            cal.add(Calendar.DATE,2);
            return ESTIMATION_FORMAT.format(cal);
        }

        else
        {
            cal.setTime(reference);
            cal.add(Calendar.DATE,5);
            return ESTIMATION_FORMAT.format(cal);
        }
    }

    public boolean isDuration(Plan reference)
    {
        return (this.plan & reference.bit) != 0;
    }

    public boolean isDuration(byte object, Plan reference)
    {
        return (this.plan & reference.bit) != 0;
    }

   public class Plan
   {
       byte bit;
       public Plan (byte bit)
       {
       }
   }
}
