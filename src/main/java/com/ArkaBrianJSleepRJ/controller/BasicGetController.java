package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.Algorithm;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import com.ArkaBrianJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    public JsonTable<T> getJsonTable();

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }


}
