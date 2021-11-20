package com.valyaJmartPK.controller;

import com.valyaJmartPK.Account;
import com.valyaJmartPK.Payment;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public abstract class PaymentController implements BasicGetController<Account>{

    public static long DELIVERED_LIMIT_MS;
    public static long ON_DELIVERY_LIMIT_MS;
    public static long ON_PROGRESS_LIMIT_MS;

    @JsonAutowired(value = Payment.class, filepath = "D:/Praktikum OOP/jmart/payment.json")
    public static JsonTable<Payment> paymentTable;

    /*public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    */

    Payment create(int buyerId, int productId, String shipmentaddress, byte shipmentPlan){
        return null;
    }
    
    boolean accept(int id){
        return true;
    }

    boolean cancel(int id){
        return true;
    }

    boolean submit(int id, String receipt){
        return true;
    }


}
