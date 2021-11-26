package com.valyaJmartPK;


import com.valyaJmartPK.dbjson.Serializable;

/**
 * Class Coupon
 *
 * Valya Sandria Akiela
 * @
 */
public class Coupon extends Serializable
{
     public final String name;
     public final int code;
     public final double cut;
     public final Type type;
     public final double minimum;
     private boolean used;

     public Coupon(int id, String name, int code, Type type, double cut, double minimum)
     {
         this.name = name;
         this.code = code;
         this.type = type;
         this.cut = cut;
         this.minimum = minimum;
         this.used = false;
     }

    public double apply(double price, double discount)
    {
        used = true;
        if (type == Type.DISCOUNT)
        {
            return Treasury.getAdjustedPrice(price, discount) * (100.0-cut)/100;
        }
        else
        {
            return Treasury.getAdjustedPrice(price, discount) - cut;
        }
    }

    public boolean canApply(double price, double discount)
    {
        if (Treasury.getAdjustedPrice(price, discount) >= minimum && used == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

     public boolean isUsed()
     {
         return used;
     }

     public enum Type
     {
        DISCOUNT,
        REBATE
     }

}
