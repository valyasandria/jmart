package com.valyaJmartPK;

import com.valyaJmartPK.dbjson.Serializable;

/**
 * class Product
 *
 *
 *
 */
public class Product extends Serializable
{
    public static int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;


    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
         this.accountId = accountId;
         this.name = name;
         this.weight = weight;
         this.conditionUsed = conditionUsed;
         this.price = price;
         this.discount = discount;
         this.category = category;
         this.shipmentPlans = shipmentPlans;
    }

    public String toString()
    {
        return ("\nAccountID: " + this.accountId + "\nName: " + this.name + "\nweight: " + this.weight + "\nprice: Rp" + this.price + "discount: " + this.discount);
    }

}
