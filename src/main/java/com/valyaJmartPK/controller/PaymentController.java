package com.valyaJmartPK.controller;

import com.valyaJmartPK.*;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

/**
 * Payment controller to create, submit, cancel, or accept payment
 * @author Valya Sandria Akiela
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

    public static final long DELIVERED_LIMIT_MS = 1000;
    public static final long ON_DELIVERY_LIMIT_MS = 1000;
    public static final long ON_PROGRESS_LIMIT_MS = 1000;
    public static final long WAITING_CONF_LIMIT_MS = 1000;
    public static ObjectPoolThread<Payment> poolThread;

    @JsonAutowired(value = Payment.class, filepath = "D://Praktikum OOP/jmart/payment.json")
    public static JsonTable<Payment> paymentTable;

    static
    {
        poolThread = new ObjectPoolThread<Payment>("Thread-PP", PaymentController::timekeeper);
        poolThread.start();
    }

    public JsonTable<Payment> getJsonTable()
    {
        return paymentTable;
    }

    //timekeeper to pay product
    protected static boolean timekeeper(Payment payment)
    {
        Payment.Record record = payment.history.get(payment.history.size()-1);
        long start = record.date.getTime();
        long finish = System.nanoTime();
        long elapsed = finish - start;

        if (record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS)
        {
            Payment.Record newRecord = new Payment.Record(Invoice.Status.FAILED,"FAILED");
            payment.history.add(newRecord);
            return true;
        }
        else if(record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS)
        {
            Payment.Record newRecord = new Payment.Record(Invoice.Status.FAILED,"FAILED");
            payment.history.add(newRecord);
            return true;
        }
        else if(record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS)
        {
            Payment.Record newRecord = new Payment.Record(Invoice.Status.ON_DELIVERY,"ON DELIVERY");
            payment.history.add(newRecord);
            return false;
        }
        else if(record.status == Invoice.Status.FINISHED && elapsed > DELIVERED_LIMIT_MS)
        {
            Payment.Record newRecord = new Payment.Record(Invoice.Status.FINISHED,"DELIVERED");
            payment.history.add(newRecord);
            return true;
        }
        else
        {
            return false;
        }
    }

    //make new payment
    @PostMapping("/create")
    Payment create
            (@RequestParam int buyerId,
             @RequestParam int productId,
             @RequestParam int productCount,
             @RequestParam String shipmentAddress,
             @RequestParam byte shipmentPlan
            )
    {
        Account acc = Algorithm.<Account>find(AccountController.accountTable, e -> e.id == buyerId);
        Product prod = Algorithm.<Product>find(ProductController.productTable, e -> e.id == productId);

        if(acc != null && prod != null)
        {
            Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress,9000, shipmentPlan, " "));

            if(acc.balance >= payment.getTotalPay(prod))
            {
                acc.balance = acc.balance - payment.getTotalPay(prod);
                Payment.Record record = new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING CONFIRMATION");
                payment.history.add(record);
                paymentTable.add(payment);
                poolThread.add(payment);
                return payment;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id)
    {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), e -> e.id == id);
        if(payment != null && payment.history.get(payment.history.size()-1).status.equals(Invoice.Status.WAITING_CONFIRMATION))
        {
            Payment.Record newRecord = new Payment.Record(Invoice.Status.ON_PROGRESS,"ON PROGRESS");
            payment.history.add(newRecord);
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id)
    {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), e->e.id == id);
        if(payment!=null && payment.history.get(payment.history.size()-1).status.equals(Invoice.Status.WAITING_CONFIRMATION))
        {
            Payment.Record newRecord = new Payment.Record(Invoice.Status.CANCELLED,"CANCELLED");
            payment.history.add(newRecord);
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/submit")
    boolean submit
            (@PathVariable int id,
             @RequestParam String receipt
            )
    {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), e->e.id == id);
        if(payment!=null && payment.history.get(payment.history.size()-1).status.equals(Invoice.Status.ON_PROGRESS) && !payment.shipment.receipt.isBlank())
        {
            payment.shipment.receipt = receipt;
            Payment.Record newRecord = new Payment.Record(Invoice.Status.ON_DELIVERY,"ON DELIVERY");
            payment.history.add(newRecord);
            return true;
        }
        return false;
    }
}
