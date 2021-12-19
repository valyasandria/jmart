package com.valyaJmartPK;

import java.util.ArrayList;
import java.util.Date;

/**
 * Calculate the total of product price to be paid and show payment status & date
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class Payment extends Invoice
{
    public int productCount;
    public Shipment shipment;
    public ArrayList<Record> history = new ArrayList<Record>();
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    //calculate total price after discount according products quantity and shipment cost
    public double getTotalPay(Product product)
    {
        return (product.price-((product.discount/100)*product.price)*productCount) + shipment.cost;
    }

    public static class Record
    {
        public final Date date = new Date();
        public String message;
        public Status status;

        public Record(Status status, String message)
        {
            this.status = status;
            this.message = message;
        }
    }
}
