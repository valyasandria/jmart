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
    create();
    createProduct();
    createCoupon();
    createShipmentDuration();
 }
 public static Product create()
 {
     return new Product("Belanja Valya", 5, true, new PriceTag(30.0), ProductCategory.SPORTS);
 }
 public static Product createProduct()
 {
     return new Product("Belanja Valya", 5, true, new PriceTag(30.0), ProductCategory.BOOK);
 }
 public static Coupon createCoupon()
 {
     return new Coupon();
 }
 public static ShipmentDuration createShipmentDuration()
 {
     return new ShipmentDuration();
 }
}
