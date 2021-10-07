package valyaJmartPK;
import java.util.ArrayList;
import java.util.Date;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Recognizable implements FileParser
{
 public Date date;
 public int buyerId;
 public int productId;
 public int complaintId;
 public Rating rating = Rating.NONE;
 public Status status = Status.WAITING_CONFIRMATION;
 public ArrayList<Record> history;
 
 protected Invoice(int id, int buyerId, int productId)
 {
     super(id);
     this.buyerId = buyerId;
     this.productId = productId;
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
 @Override
 public boolean read(String content)
 {
    return true;
 }

 public double getTotalPay()
 {
     return 0.0;
 }
 
 public class Record
 {
     public Date date;
     public String message;
     public Status status;
 }

 @Override
 public Object write()
 {
     return null;
 }
}
