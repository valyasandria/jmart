package com.valyaJmartPK.controller;

import com.valyaJmartPK.ObjectPoolThread;
import com.valyaJmartPK.Payment;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public abstract class PaymentController implements BasicGetController<Payment>{

    public static final long DELIVERED_LIMIT_MS = 1000;
    public static final long ON_DELIVERY_LIMIT_MS = 1000;
    public static final long ON_PROGRESS_LIMIT_MS = 1000;
    public static ObjectPoolThread<Payment> poolThread;

    @JsonAutowired(value = Payment.class, filepath = "D:/Praktikum OOP/jmart/payment.json")
    public static JsonTable<Payment> paymentTable;

    static
    {
        poolThread = new ObjectPoolThread<Payment>("Thread-PP", PaymentController::timekeeper);
        poolThread.start();
    }

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    protected static boolean timekeeper(Payment payment){

        return true;
    }

    @PostMapping("/create")
    Payment create
            (@RequestParam int buyerId,
             @RequestParam int productId,
             @RequestParam String shipmentAddress,
             @RequestParam byte shipmentPlan
            )
    {
        return null;
    }

    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id)
    {
        return true;
    }

    @PostMapping("/{id}/cancel ")
    boolean cancel(@PathVariable int id)
    {
        return true;
    }

    @PostMapping("/{id}/cancel ")
    boolean submit
            (@PathVariable int id,
             @RequestParam String receipt
            )
    {
        return true;
    }
}
