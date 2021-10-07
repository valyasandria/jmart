package valyaJmartPK;
import java.util.ArrayList;

public class Filter {
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less)
    {
        ArrayList <PriceTag> priceTags = new ArrayList<>(); 
        for (PriceTag obj : list)
        {
            if(less && obj.getAdjustedPrice() < value)
            {
                priceTags.add(obj) ;
            }
            else if (less && obj.getAdjustedPrice() > value)
            {
                priceTags.add(obj) ;
            }
        }
        return priceTags;
    }

    public void filterProductRating(ArrayList<ProductRating> list, double value, boolean less)
    {
        ArrayList <PriceTag> ProductRating = new ArrayList<>();
        if(less){
            for(int i = 0; i<list.size();i++){
                if(list.get(i).getAverage()<value){
                    list.remove(i);
                }
            }
        }
        else{
            for(int i = 0; i<list.size();i++) {
                if (list.get(i).getAverage() >= value) {
                    list.remove(i);
                }
            }
        }
        
    }
}
