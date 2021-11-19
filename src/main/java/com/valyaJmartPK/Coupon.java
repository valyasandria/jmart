package com.valyaJmartPK;


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
        this.used = true;
        if(type == Type.REBATE)
        {
            return (Treasury.getAdjustedPrice(this.minimum, this.cut) - cut );
        }
        else{
            return (Treasury.getAdjustedPrice(this.minimum, this.cut) * (1-(cut/100)));
        }
    }

    public boolean canApply(double price, double discount)
    {
        if((Treasury.getAdjustedPrice(this.minimum, this.cut) >= this.minimum) && (!this.used))
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

     public static enum Type
     {
        DISCOUNT,
        REBATE
     }

}
