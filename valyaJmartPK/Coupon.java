package valyaJmartPK;


/**
 * Class Coupon
 *
 * Valya Sandria Akiela
 * @2006522650
 */
public class Coupon
{
 public String name;
 public int code;
 public double cut;
 public Type type;
 public double minimum;
 private boolean used;
 public PriceTag priceTag;
 
 
 public Coupon(String name, int code, Type type, double cut, double minimum)
 {
     this.name = name;
     this.code = code;
     this.cut = cut;
     this.type = type;
     this.used = false;
     this.minimum = minimum;
 }
 public boolean isUsed()
 {
     return this.used;
 }
 public boolean canApply(PriceTag priceTag)
 {
     if(priceTag.getAdjustedPrice() >= this.minimum && this.used == false)
     {
         return true;
     }
     else
     {
         return false;
     }
 }
 public double apply(PriceTag priceTag)
 {
     this.used = true;
     return priceTag.getAdjustedPrice()-this.cut;
 }
 public enum Type
 {
    DISCOUNT,
    REBATE
 }
}
