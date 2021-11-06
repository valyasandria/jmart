package valyaJmartPK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.File;
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

    public static List<Product> filterByCategory (List<Product> list, ProductCategory category){
        System.out.println(list);
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

    public static List<Product> read (String filepath)
    {
        return null;
    }

 public static void main(String[] args)
 {
     System.out.println("account id: " + new Account(0,null, null, null, -1).id);
     System.out.println("account id: " + new Account(0,null, null, null, -1).id);
     System.out.println("account id: " + new Account(0,null, null, null, -1).id);

     System.out.println("payment id: " + new Account(-1, null, null, null, -1).id);
     System.out.println("paymemt id: " + new Account(-1,null, null, null, -1).id);
     System.out.println("payment id: " + new Account(-1,null, null, null, -1).id);

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
         filtered.forEach(product -> System.out.println(product.price));

     }
     catch (Throwable t)
     {
         t.printStackTrace();
     }

 }
}
