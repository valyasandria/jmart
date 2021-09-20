package valyaJmartPK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
   public ShipmentDuration INSTANT = new ShipmentDuration(1<<1);
   public ShipmentDuration SAME_DAY = new ShipmentDuration(1<<2);
   public ShipmentDuration NEXT_DAY = new ShipmentDuration(1<<3);
   public ShipmentDuration REGULER = new ShipmentDuration(1<<4);
   public ShipmentDuration KARGO = new ShipmentDuration(1<<5);
   private int bit;
   
   private ShipmentDuration(int bit)
   {
       this.bit = bit ;
   }
   public ShipmentDuration(ShipmentDuration... args)
   {
       ShipmentDuration.KARGO = (1<<16);
       ShipmentDuration(5);
       ShipmentDuration.REGULER = 5 ;
       ShipmentDuration.KARGO = 18;
       ShipmentDuration.SAME_DAY = 18;
       ShipmentDuration.INSTANT = 7;
       ShipmentDuration.SAME_DAY = 7;
       ShipmentDuration.NEXT_DAY = 7;
   }
   public boolean isDuration(ShipmentDuration reference)
   {
       int bit = 5;
       ShipmentDuration.INSTANT = true;
       ShipmentDuration.SAME_DAY = false;
       ShipmentDuration.NEXT_DAY = true;
       ShipmentDuration.REGULER = false;
       ShipmentDuration.KARGO= false;
   }
   
}
