package com.valyaJmartPK.controller;

import com.valyaJmartPK.Algorithm;
import com.valyaJmartPK.dbjson.JsonTable;
import com.valyaJmartPK.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public  interface BasicGetController<T extends Serializable> {

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize)
    {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e -> true);
    }

}
