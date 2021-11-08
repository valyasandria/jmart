package valyaJmartPK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

/** 
 *
 * 
 *
 *
 * 
 */
class Jmart
{
    class Country
    {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static List<Product> filterByAccountId (List<Product>list, int accountId, int page, int pageSize)
    {
        //list.stream().filter(listProduct -> paginate(list, page, pageSize, ).forEach(System.out::println);
        return list;
    }

    public static List<Product> filterByCategory (List<Product> list, ProductCategory category){
        System.out.println(list);
        return list;
    }

    public static List<Product> filterByName (List<Product>list, String search, int page, int pageSize)
    {
        if (list.contains(search)){
            list = new ArrayList<Product>();
        }
        else{
            list = null;
        }
            return list;
    }

    public static List<Product> filterByPrice (List<Product> list,  double minPrice, double maxPrice){
        if(minPrice == 0.0)
        {
            System.out.println(list);
        }
        else if (maxPrice == 0.0)
        {
            System.out.println(list);
        }
        else if( minPrice != 0.0 && maxPrice != 0.0)
        {
            System.out.println(list);
        }

        return list;

    }

    public static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred)
    {
        return null;
    }

    public static List<Product> read (String filepath)
    {
        return null;
    }


 public static void main(String[] args)
 {
     System.out.println("account id : " + new Account(null, null, null, -1).id);
     System.out.println("account id : " + new Account(null, null, null, -1).id);
     System.out.println("account id : " + new Account(null, null, null, -1).id);

     System.out.println("account id : " + new Payment(-1, -1, -1, null).id);
     System.out.println("account id : " + new Payment(-1, -1, -1, null).id);
     System.out.println("account id : " + new Payment(-1, -1, -1, null).id);

     String filepath = "D:/Praktikum OOP/jmart/city.json";
     Gson gson = new Gson();
     try
     {
         BufferedReader br = new BufferedReader(new FileReader(filepath));
         Country input = gson.fromJson(br, Country.class);
         System.out.println("name: " + input.name);
         System.out.println("population: " + input.population);
         System.out.println("states:");
         input.listOfStates.forEach(state -> System.out.println(state));

     }
     catch (IOException e)
     {
         e.printStackTrace();
     }

     String filepath2 = "D:/Praktikum OOP/jmart/randomProductList.json";
     try
     {
         final JsonReader reader = new JsonReader(new FileReader(filepath2));
         List<Product> list = read(filepath2);
         List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
         //filtered.forEach(product -> System.out.println(product.price));

     }
     catch (Throwable t)
     {
         t.printStackTrace();
     }

 }
}
