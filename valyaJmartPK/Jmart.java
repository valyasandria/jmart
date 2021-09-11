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
     float discountedPrice;
     if (discountPercentage>100.0f){
         discountedPrice = 0;
     }
     else{
         discountedPrice = price - discountPercentage;
     }
     return discountedPrice;
 }
 public int getOriginalPrice(int discountedPrice, float discountedPercentage){
     int originalPrice;
     
 }
 public float getCommissionMultiplier(){
     
 }
 public int getAdjustedPrice (int g){
     
 }
 public int getAdminFee(int a){
     
 }
}
