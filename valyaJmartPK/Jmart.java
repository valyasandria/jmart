package valyaJmartPK;

public class Jmart
{
 public static void main(String[] args){
     System.out.println ("Welcome to Jmart!");
 }
 public int getPromo(){
     return 0;
 }
 public String getCustomer() {
     return "oop";
 }
 public float getDiscountPercentage(int before, int after){
     float potongan;
     if (before < after) {
         potongan = 0;
     }
     else {
         potongan = before-after;
     }
     return potongan;
 }
 public int getDiscountedPrice (int price, float discountPercentage){
     int discountedPrice ;
     int myDiscount = (int) discountedPrice;
     if (discountPercentage>100.0f){
         discountedPrice = 0;
     }
     else{
         discountedPrice = price - myDiscount;
     }
     return discountedPrice;
 }
 public int getOriginalPrice(int discountedPrice, float discountedPercentage){
     int myDiscountPercent = (int) discountedPercentage;
     int originalPrice = discountedPrice + myDiscountPercent;
     return originalPrice ;
 }
 public float getCommissionMultiplier(){
     return 0.05f;
 }
 public int getAdjustedPrice (int price){
     int disc = (int) 0.05f;
     price = price + disc;
     return price;
 }
 public int getAdminFee(int price){
     int disc = (int) 0.05f;
     return price * disc;
 }
}
