package valyaJmartPK;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction extends Recognizable
{
    public String time = "Time" ;
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;
 
   public enum Rating
 {
    NONE,
    BAD,
    NEUTRAL,
    GOOD
 }
 
 public Transaction (int id, int buyerId, int storeId)
 {
     super(id);
     this.buyerId = buyerId;
     this.storeId = storeId;
 }
 public Transaction (int id, Account buyer, Store store)
 {
     super(id);
     this.buyer = buyer;
     this.store = store;
 }
}
