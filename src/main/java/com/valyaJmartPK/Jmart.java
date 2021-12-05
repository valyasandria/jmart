package com.valyaJmartPK;

import com.valyaJmartPK.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** 
 *
 * 
 *
 *
 * 
 */
@SpringBootApplication
class Jmart
{
    public static long DELIVERED_LIMIT_MS = 3;
    public static long ON_DELIVERY_LIMIT_MS = 2;
    public static long ON_PROGRESS_LIMIT_MS = 1;
    public static long WAITING_CONF_LIMIT_MS = 2;


    /*public static List<Product> filterByAccountId (List<Product>list, int accountId, int page, int pageSize)
    {
        return paginate(list, page, pageSize, product -> product.accountId == accountId);
    }

    public static List<Product> filterByCategory (List<Product> list, ProductCategory category){
        return Algorithm.<Product>collect(list, prod -> prod.category == category);
    }

    public static List<Product> filterByName (List<Product>list, String search, int page, int pageSize)
    {
        return paginate(list, page, pageSize, product -> product.name.toLowerCase().contains(search.toLowerCase()));
    }

    public static List<Product> filterByPrice (List<Product> list,  double minPrice, double maxPrice){
        if(minPrice <= 0.0)
        {
            return  Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice);
        }
        else if (maxPrice <= 0.0)
        {
            return  Algorithm.<Product>collect(list, prod -> prod.price >= minPrice);
        }
        else
        {
            return  Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice && prod.price >= minPrice);
        }
    }

    public static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred)
    {
        int iteration = 0;
        int occurrences = 0;
        int startInd = page * pageSize;
        List<Product> pageList = new ArrayList<>(pageSize);

        //skip first occurrences
        for(; iteration < list.size() && occurrences < startInd ; iteration++)
        {
            if(pred.predicate(list.get(iteration)))
            {
                occurrences++;
            }
        }
        for (int i = iteration; i < list.size() && pageList.size() < pageSize; i++)
        {
            if (pred.predicate(list.get(i)))
            {
                pageList.add(list.get(i));
            }
        }
        return pageList;
    }

    public static List<Product> read (String filepath) throws FileNotFoundException
    {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Product>>() {}.getType();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        return gson.fromJson(br, userListType);
    }

*/
 public static void main(String[] args)
 {

     JsonDBEngine.Run(Jmart.class);
     SpringApplication.run(Jmart.class, args);
     Runtime.getRuntime().addShutdownHook(new Thread(()->JsonDBEngine.join()));
    /*
     try
     {
         JsonTable<Payment> table = new JsonTable<>(Payment.class, "randomPaymentList.json");
         ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimeKeeper);
         paymentPool.start();

         table.forEach(payment -> paymentPool.add((Payment) payment));
         while(0 != paymentPool.size()){
             paymentPool.exit();
         }


         while(paymentPool.isAlive()){
             System.out.println("Thread exited successfully");
         }


         Gson gson = new Gson();

         table.forEach(payment -> {
             String history = gson.toJson(payment);
             System.out.println(history);
         });
     }
     catch (Throwable t) {
         t.printStackTrace();
     }


     System.out.println("account id : " + new Account(null, null, null).id);
     System.out.println("account id : " + new Account(null, null, null).id);
     System.out.println("account id : " + new Account(null, null, null).id);

     System.out.println("account id : " + new Payment(-1, -1, -1, null).id);
     System.out.println("account id : " + new Payment(-1, -1, -1, null).id);
     System.out.println("account id : " + new Payment(-1, -1, -1, null).id);


     String filepath2 = "D:/Praktikum OOP/jmart/randomProductList.json";
     try
     {
         final JsonReader reader = new JsonReader(new FileReader(filepath2));
         List<Product> list = read(filepath2);
         List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
        // filtered.forEach(product -> System.out.println(product.price));

     }
     catch (Throwable t)
     {
         t.printStackTrace();
     }

     try{
         String filepath = "D:/Praktikum OOP/jmart/account.json";
         JsonTable<Account> tableAccount = new JsonTable<>(Account.class, "account.json");
         tableAccount.add(new Account("Valya Sandria", "valya.sandria@gmail.com", "abcD67_"));
         tableAccount.writeJson();

         tableAccount = new JsonTable<>(Account.class, filepath);
         tableAccount.forEach(account -> System.out.println(account.toString()));
     }
     catch (Throwable t){
         t.printStackTrace();
     }
      */
 }

 public static boolean paymentTimeKeeper(Payment payment)
 {

     long start = System.currentTimeMillis();
     long finish = System.currentTimeMillis();
     long timeElapsed = finish - start;

     if (payment.history.equals(Invoice.Status.WAITING_CONFIRMATION) && timeElapsed > WAITING_CONF_LIMIT_MS)
     {
         payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
     }
     else if(payment.history.equals(Invoice.Status.ON_PROGRESS) && timeElapsed > ON_PROGRESS_LIMIT_MS)
     {
         payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
     }
     else if(payment.history.equals(Invoice.Status.ON_DELIVERY) && timeElapsed > ON_DELIVERY_LIMIT_MS)
     {
         payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
         return true;
     }
     else if(payment.history.equals(Invoice.Status.FINISHED) && timeElapsed > DELIVERED_LIMIT_MS)
     {
         payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
         return true;
     }

     return false;
 }
}
