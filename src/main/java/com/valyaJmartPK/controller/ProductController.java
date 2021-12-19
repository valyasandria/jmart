package com.valyaJmartPK.controller;

import com.valyaJmartPK.*;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Product controller to create new product
 * @author Valya Sandria Akiela
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {

    @JsonAutowired(value = Product.class, filepath = "D://Praktikum OOP/jmart/product.json")
    public static JsonTable<Product> productTable;

    public JsonTable<Product> getJsonTable(){
        return productTable;
    }

    @GetMapping ("{id}/store")
    List<Product> getProductByStore
            (@PathVariable int id,
             @RequestParam int page,
             @RequestParam int pageSize
            )
    {
        return Algorithm.<Product>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    //add new product to the store
    @PostMapping  ("/create")
    Product createProduct
            (@RequestParam int accountId,
             @RequestParam String name,
             @RequestParam int weight,
             @RequestParam boolean conditionUsed,
             @RequestParam double price,
             @RequestParam double discount,
             @RequestParam ProductCategory category,
             @RequestParam byte shipmentPlans
            )
    {
        for(Product temp : productTable)
        {
            if(temp.accountId == accountId)
            {
                Product product = new Product(accountId, name, weight,conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return  product;
            }
        }
        return null;
    }

    @GetMapping ("/getProductFiltered")
    List<Product> getProductFiltered
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )

    {
        List<Product> temporaryProduct= new ArrayList<Product>();
        for (Product temporary : productTable)
        {
            if (temporary.accountId == accountId)
                if (temporary.name.contains(search))
                    if (minPrice <= temporary.price)
                        if (maxPrice >= temporary.price)
                            if (temporary.category == category)
                                temporaryProduct.add(temporary);
        }
        return temporaryProduct;
    }
}
