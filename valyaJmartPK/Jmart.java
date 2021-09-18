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
 public static Product create()
 {
     return new Product("Belanja Valya", 5, true, new PriceTag(30.0), ProductCategory.SPORTS);
 }
}
