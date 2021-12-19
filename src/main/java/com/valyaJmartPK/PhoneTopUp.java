package com.valyaJmartPK;

/**
 * used to top up the balance from mobile phone
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class PhoneTopUp extends Invoice
{
    public String phoneNumber;
    public Status status;

    public PhoneTopUp(int buyerId, int productId, String phoneNumber)
    {
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public double getTotalPay(Product product)
    {
        return super.getTotalPay(product);
    }
}
