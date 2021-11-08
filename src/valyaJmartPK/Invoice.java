package valyaJmartPK;
import java.util.ArrayList;
import java.util.Date;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable
{
 public Date date;
 public int buyerId;
 public int productId;
 public int complaintId;
 public Rating rating;
 public Status status;
 public ArrayList<Record> history;
 
 protected Invoice(int buyerId, int productId)
 {
     this.buyerId = buyerId;
     this.productId = productId;
     this.date = new Date();
     this.complaintId = 1;
     this.rating = Rating.NONE;
     this.status = Status.WAITING_CONFIRMATION;
 }
 public enum Status
 {
     WAITING_CONFIRMATION,
     CANCELLED,
     ON_PROGRESS,
     ON_DELIVERY,
     COMPLAINT,
     FINISHED,
     FAILED;
 }
 public enum Rating
 {
     NONE,
     BAD,
     NEUTRAL,
     GOOD;
 }

 public abstract double getTotalPay();
 
 public class Record
 {
     public Date date;
     public String message;
     public Status status;
 }

}
