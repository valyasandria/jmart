package com.valyaJmartPK.controller;

import com.valyaJmartPK.Algorithm;
import com.valyaJmartPK.Coupon;
import java.util.List;

import com.valyaJmartPK.Invoice;
import com.valyaJmartPK.dbjson.JsonAutowired;
import com.valyaJmartPK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {

    @JsonAutowired(value = Coupon.class, filepath = "D:/Praktikum OOP/jmart/coupon.json")
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable(){
        return couponTable;
    }

    @GetMapping("{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        return Coupon.isUsed();
    }

    @GetMapping("{id}/canApply")
    boolean canApply
            (@PathVariable int id,
             @RequestParam double price,
             @RequestParam double discount
            )
    {
        return Coupon.canApply(price, discount);
    }

    @GetMapping("{id}/canAvailable")
    List<Coupon> getAvailable
            (
             @RequestParam int page,
             @RequestParam int pageSize
            )
    {
        return Algorithm.<Coupon>paginate(getJsonTable(), page, pageSize, e -> false);
    }
}
