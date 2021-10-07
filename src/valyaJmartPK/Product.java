package valyaJmartPK;

/**
 * class Product
 *
 *
 *
 */
public class Product extends Recognizable implements FileParser
{
public int storeId;
public String name;
public int weight;
public boolean conditionUsed;
public PriceTag priceTag;
public ProductCategory category;
public ProductRating rating;
public Shipment.MultiDuration multiDuration;

 public Product(int id, int storeId, String name, int weight, boolean conditionUsed,PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration)
 {
     super(id);
     this.storeId = storeId;
     this.name = name;
     this.weight = weight;
     this.conditionUsed = conditionUsed;
     this.priceTag = priceTag;
     this.category = category;
     this.multiDuration = multiDuration;
     this.rating = new ProductRating();
 }
 public Product(int id, Store store, String name, int weight, boolean conditionUsed,PriceTag priceTag, ProductCategory category)
 {
     super(id);
     this.name = name;
     this.weight = weight;
     this.conditionUsed = conditionUsed;
     this.priceTag = priceTag;
     this.category = category;
     this.rating = new ProductRating();
     this.storeId = store.id;
 }
 @Override 
 public boolean read(String content)
 {
     return true;
 }
 @Override
 public Object write()
 {
     return null;
 }
 @Override
 public String toString()
 {
     return ("Name: " + this.name + "\nweight: " + this.weight + "\nconditionUsed: " + this.conditionUsed + "\npriceTag: " + this.priceTag + "\ncategory: " + this.category + "\nrating: 0" + "\nstoreId: " + this.storeId);
 }
}
