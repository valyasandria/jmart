package valyaJmartPK;


/**
 * class Product
 *
 * Valya Sandria Akiela
 * 2006522650
 */
public class Product extends Recognizable implements FileParser
{
private static int idCounter = 0;
public final int id;
public String name;
public int weight;
public boolean conditionUsed;
public PriceTag priceTag;
public ProductCategory category;
public ProductRating rating;
public int storeId;
public Store store;

 public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
 {
     super(id);
     this.storeId = storeId;
     this.name = name;
     this.weight = weight;
     this.conditionUsed = conditionUsed;
     this.priceTag = priceTag;
     this.category = category;
     this.rating = new ProductRating();
 }
 public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category)
 {
     super(id);
     this.store = store;
     this.storeId = storeId;
     this.name = name;
     this.weight = weight;
     this.conditionUsed = conditionUsed;
     this.priceTag = priceTag;
     this.category = category;
     this.rating = new ProductRating();
     
 }
 @Override 
 public boolean read(String content)
 {
     return false;
 }
}
