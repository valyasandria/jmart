package com.valyaJmartPK;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Create shipment detail and determine arrival date according to the shipping service used
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class Shipment
{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1 << 0));    //1
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));   //2
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));   //4
    public static final Plan REGULER = new Plan((byte)(1 << 3));    //8
    public static final Plan KARGO = new Plan((byte)(1 << 4));      //16

   public String address;
   public int cost;
   public byte plan;
   public String receipt;

   //shipment detail
    public Shipment(String address, int cost, byte plan, String receipt)
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    //determine estimated arrival
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
        if((reference.bit & this.plan) != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isDuration(byte object, Plan reference)
    {
        if((reference.bit & object) != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

   public static class Plan
   {
       public final byte bit;
       private Plan (byte bit)
       {
           this.bit = bit;
       }
   }
}
