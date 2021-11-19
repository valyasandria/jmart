package com.valyaJmartPK;
import java.util.ArrayList;
import java.util.Date;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public  class Invoice extends Serializable
{
     public final Date date = new Date();
     public int buyerId;
     public int productId;
     public int complaintId = -1;
     public Rating rating = Rating.NONE;
     public Status status;

     protected Invoice(int buyerId, int productId)
     {
         this.buyerId = buyerId;
         this.productId = productId;

     }

     public enum Status
     {
         WAITING_CONFIRMATION,
         CANCELLED,
         ON_PROGRESS,
         ON_DELIVERY,
         COMPLAINT,
         FINISHED,
         FAILED;
     }

     public enum Rating
     {
         NONE,
         BAD,
         NEUTRAL,
         GOOD;
     }

     public double getTotalPay(Product product)
     {
         return 0.0;
     }

}
