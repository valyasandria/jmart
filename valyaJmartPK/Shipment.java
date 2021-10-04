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
   public final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("Date: 'EEE MMMMMMM dd yyyy");
   public final Duration INSTANT = new Duration ((byte) (1<<0));
   public final Duration SAME_DAY = new Duration ((byte)(1<<1));
   public final Duration NEXT_DAY = new Duration((byte) (1<<2));
   public final Duration REGULER = new Duration ((byte) (1<<3));
   public final Duration KARGO = new Duration ((byte) (1<<4));
   private final byte bit;
   
   
    
   Calendar cal = Calendar.getInstance();
   String current_date = ESTIMATION_FORMAT.format(cal.setTime(reference));
   private Duration(byte bit)
   {
       this.bit = bit ;
   }
   
   public String getEstimatedArrival(Date reference)
   {
	   if(Duration == INSTANT && SAME_DAY) {
		   return reference;
	   }
       else if (Duration == NEXT_DAY){
           cal.add(Calendar.DATE,1);
       }
       else if (Duration == REGULER){
           cal.add(Calendar.DATE,2);
       }
       else if (Duration == KARGO){
           cal.add(Calendar.DATE,5);
       }
   }
   }
   
   public static class MultiDuration
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
       if((this.bit & reference.bit) != 0 )
       {
           return true;
       }
       else
       {
           return false;
       }
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
