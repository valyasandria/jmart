package com.valyaJmartPK;


import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;
    public static ArrayList<Record> history = new ArrayList<Record>();
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay(Product product) {
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
