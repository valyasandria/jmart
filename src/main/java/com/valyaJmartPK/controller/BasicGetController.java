package com.valyaJmartPK.controller;

import com.valyaJmartPK.Algorithm;
import com.valyaJmartPK.dbjson.JsonTable;
import com.valyaJmartPK.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Basic get controller (id and page)
 * @author Valya Sandria Akiela
 * @param <T>
 */
public  interface BasicGetController<T extends Serializable> {

    JsonTable<T> getJsonTable();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public default T getById(@PathVariable int id)
    {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
    }

    @RequestMapping(value="/page", method = RequestMethod.GET)
    public default List<T> getPage
            (
                    @RequestParam(defaultValue="0") int page,
                    @RequestParam(defaultValue="5") int pageSize
            )
    {
        final JsonTable<T> table = getJsonTable();
        return Algorithm.<T>paginate(table, page, pageSize, o -> true);
    }

}
