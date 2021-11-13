package valyaJmartPK;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/** 
 *
 * 
 *
 *
 * 
 */
class Jmart
{


    public static List<Product> filterByAccountId (List<Product>list, int accountId, int page, int pageSize)
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
        return null;
    }


 public static void main(String[] args)
 {
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
 }
}
