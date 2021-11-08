package valyaJmartPK;

/**
 * class ProductRating
 *
 * Valya Sandria Akiela
 * 2006522650
 */
public class ProductRating
{
 private long total;
 private long count;
 
 public ProductRating()
 {
     total = 0;
     count = 0;
 }
 public void insert(int rating)
 {
     this.total += rating;
     this.count++;
 }
 public double getAverage()
 {
     if(count <= 0)
     {
         return 0.0;
     }
     else
     {
        return (double) total/count;
     }
 }
 public long getCount()
 {
     return count;
 }
 public long getTotal()
 {
     return total;
 }
}
