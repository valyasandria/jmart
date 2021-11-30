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

    @JsonAutowired(value = Coupon.class, filepath = "D://Praktikum OOP/jmart/coupon.json")
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable(){
        return couponTable;
    }

    @GetMapping("{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Coupon coupon = Algorithm.<Coupon>find(getJsonTable(), e->e.id == id);
        if (coupon != null)
        {
            return coupon.isUsed();
        }
        else
        {
            return true;
        }
    }

    @GetMapping("{id}/canApply")
    boolean canApply
            (@PathVariable int id,
             @RequestParam double price,
             @RequestParam double discount
            )
    {
        Coupon coupon = Algorithm.<Coupon>find(getJsonTable(), e->e.id == id);
        if (coupon != null){
            return coupon.canApply(price, discount);
        }
        else
        {
            return true;
        }
    }

    @GetMapping("{id}/canAvailable")
    public List<Coupon> getAvailable
            (@RequestParam(defaultValue = "1") int page,
             @RequestParam(defaultValue = "2") int pageSize
            )
    {
        return Algorithm.<Coupon>paginate(getJsonTable(), page, pageSize, e-> !e.isUsed());
    }
}
