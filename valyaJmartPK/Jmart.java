package valyaJmartPK;

public class Jmart
{
 public static void main(String[] args){
     System.out.println ("Welcome to Jmart!");
     getPromo();
     getCustomer();
     getDiscountPercentage(1000,900);
     getDiscountedPrice(1000, 10.0f);
     getOriginalPrice(900,10.0f);
     getCommissionMultiplier();
     getAdjustedPrice(1000);
     getAdminFee(1000);
 }
 public static int getPromo(){
     return 0;
 }
 public static String getCustomer() {
     return "oop";
 }
 public static float getDiscountPercentage(int before, int after){
     float discountPercentage;
     if (before < after) {
         discountPercentage = 0.0f;
     }
     else {
         discountPercentage = (before-after)/10;
     }
     return discountPercentage;
 }
 public static int getDiscountedPrice(int price, float discountPercentage){
     int discountedPrice;
     if (discountPercentage > 100.0f){
         discountedPrice = 0;
     }
     else{
         discountedPrice = (int) (100.0f-discountPercentage) * price/100;
     }
     return discountedPrice;
 }
 public static int getOriginalPrice(int discountedPrice, float discountPercentage){
     int myDiscountPercent = (int) discountPercentage;
     int OriginalPrice = discountedPrice + (myDiscountPercent * 10);
     return OriginalPrice;
 }
 public static float getCommissionMultiplier(){
     return 0.05f;
 }
 public static int getAdjustedPrice(int price){
     float comm = 5.0f;
     int AdjustedPrice;
     AdjustedPrice = (int) ((comm * price)/100) + price;
     return AdjustedPrice;
 }
 public static int getAdminFee(int price){
     float comm = 5.0f;
     return (int) (comm * price)/100;
 }
}
