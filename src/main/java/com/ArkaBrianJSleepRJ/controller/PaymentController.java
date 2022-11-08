package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.Algorithm;
import com.ArkaBrianJSleepRJ.Payment;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    JsonTable<Payment> paymentTable;

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam Date from,
            @RequestParam Date to
    ){
        return new Payment(buyerId, renterId, roomId, from, to);
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @Override
    public Payment getById(int id) {
        return Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
    }

    @Override
    public List<Payment> getPage(int page, int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
