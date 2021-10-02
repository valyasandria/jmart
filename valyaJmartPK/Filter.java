package valyaJmartPK;
import java.util.*;

public class Filter {
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less)
    {
        ArrayList <PriceTag> priceTags = new ArrayList<>(); 
        for (PriceTag var : list)
        {
            if(less && obj.getAdjustedPrice() < value)
            {
                pricetags.add(obj) ;
            }
            else if (less && obj.getAdjustedPrice() > value)
            {
                pricetags.add(obj) ;
            }
        }
        return priceTags;
    }

    public void filterProductRating(ArrayList<ProductRating> list, double value, boolean less)
    {
        if(less && obj.getAdjustedPrice() < value)
        {
            clear(ProductRating.getAverage());
        }
        else if (less && obj.getAdjustedPrice() > value)
        {
            clear(ProductRating.getAverage());
        }
    }
}
