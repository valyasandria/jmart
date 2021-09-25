package valyaJmartPK;

/** 
 * Project Praktikum OOP
 * 
 * Valya Sandria Akiela
 * 2006522650
 * 
 */
public class Jmart
{
 public static void main(String[] args)
 {

 }
 public static Product createProduct()
 {
     return new Product("Belanja Valya", 5, true, new PriceTag(30.0), ProductCategory.BOOK);
 }
 public static Coupon createCoupon()
 {
     return new Coupon("Kupon Valya", 22124, Coupon.Type.REBATE, 15000, 70000);
 }
 public static ShipmentDuration createShipmentDuration()
 {
     return new ShipmentDuration(ShipmentDuration.SAME_DAY, ShipmentDuration.INSTANT);
 }
}
