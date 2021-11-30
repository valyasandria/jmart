package com.valyaJmartPK.controller;

import com.valyaJmartPK.*;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return Algorithm.<Product>paginate(getJsonTable(), page, pageSize, (e) -> e.id == Product.accountId);
    }

    @PostMapping  ("/create")
    Product create
            (int accountId, String name, int weight, boolean conditionUsed, double price,double discount,ProductCategory category, byte shipmentPlans)
    {
        Product myAcc = Algorithm.<Product>find(productTable, (e) -> e.accountId == accountId);
        //if (myAcc != null && myAcc.store != null )
        //{
        //    return new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
        //}
        //else
        //{
        return null;
        //}
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
        return Algorithm.<Product>collect(productTable, prod -> prod.category == category);
    }
}
