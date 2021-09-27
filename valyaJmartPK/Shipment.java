package valyaJmartPK;


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
       bit = flags;
   }
   public boolean isDuration(Duration reference)
   {
       return (bit & reference.bit)!=0;
   }
   }

   @Override
   public boolean read(String content)
   {
        return false;
   }
}
