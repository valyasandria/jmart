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
public class Shipment implements FileParser
{
   public String address;
   public int shipmentCost;
   public Duration duration;
   public String receipt;
   
   public class Duration
   {
   public final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E, MM/dd/yyyy");
   public final Duration INSTANT = new Duration ((byte) (1<<0));
   public final Duration SAME_DAY = new Duration ((byte)(1<<1));
   public final Duration NEXT_DAY = new Duration((byte) (1<<2));
   public final Duration REGULER = new Duration ((byte) (1<<3));
   public final Duration KARGO = new Duration ((byte) (1<<4));
   private final byte bit;

   private Duration(byte bit)
   {
       this.bit = bit ;
   }

   public String getEstimatedArrival(Date reference)
   {
       Calendar cal = Calendar.getInstance();
       if(this.bit == 1<<0|| this.bit == 1<<1)
       {
           return ESTIMATION_FORMAT.format(reference.getTime());
       }

       else if(this.bit == 1<<2)
       {
           cal.setTime(reference);
           cal.add(Calendar.DATE,1);
           return ESTIMATION_FORMAT.format(cal);
       }

       else if(this.bit == 1<<3)
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
   }
   
   public class MultiDuration
   {
       public byte bit;
       public MultiDuration(MultiDuration... args)
       {
           byte flags = 0;
           for(byte i = 0; i < args.length; i++)
           {
               flags |= args[i].bit;
           }
           this.bit = flags;
       }
       public boolean isDuration(Duration reference)
       {
           return (this.bit & reference.bit) != 0;
       }
   }

   public Shipment(String address, int shipmentCost, Duration duration, String receipt)
   {
     this.address = address;
     this.shipmentCost = shipmentCost;
     this.duration = duration;
     this.receipt = receipt;
   }
   @Override
   public boolean read(String content)
   {
        return false;
   }
   
   @Override
   public Object write()
   {
       return null;
   }
}
