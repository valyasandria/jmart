package com.valyaJmartPK;

import com.valyaJmartPK.dbjson.Serializable;
import java.util.Date;

/**
 * Show invoice from buyer transaction
 *
 * @author Valya Sandria Akiela
 * @version 1.0
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
        return product.price;
    }

    //
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

     //products rating from buyer
     public static enum Rating
     {
         NONE,
         BAD,
         NEUTRAL,
         GOOD;
     }
}
