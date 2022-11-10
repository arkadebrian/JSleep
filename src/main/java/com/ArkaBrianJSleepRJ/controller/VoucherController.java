package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.*;
import com.ArkaBrianJSleepRJ.dbjson.JsonAutowired;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    @JsonAutowired(value = Voucher.class,
            filepath = "C:\\Users\\Arka Brian\\Documents\\Arka\\Kuliah\\UI\\Semester 3\\OOP\\Praktikum\\PraktikumCode\\JSleep\\src\\main\\java\\com\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @GetMapping
    String index() {
        return "voucher page";
    }

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            )
    {
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());
    }

}
