package com.valyaJmartPK;
import com.valyaJmartPK.dbjson.Serializable;

import java.util.Date;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable
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

    public double getTotalPay(Product product) {
        return 0;
    }

    public static enum Status
     {
         WAITING_CONFIRMATION,
         CANCELLED,
         ON_PROGRESS,
         ON_DELIVERY,
         COMPLAINT,
         FINISHED,
         FAILED;
     }

     public static enum Rating
     {
         NONE,
         BAD,
         NEUTRAL,
         GOOD;
     }

}
