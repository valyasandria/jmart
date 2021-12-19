package com.valyaJmartPK;

import com.valyaJmartPK.dbjson.Serializable;

/**
 * Add new product to the store
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class Product extends Serializable
{
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public double price;
    public double discount;
    public ProductCategory category;
    public byte shipmentPlans;

    //represents products detail
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
        return ("\naccountId: " + this.accountId + "\nname: " + this.name + "\nweight: " + this.weight + "\nprice: Rp" + this.price + "\ndiscount: " + this.discount + "\ncategory" + this.category +"\nshipmentPlans" + this.shipmentPlans);
    }

}
