package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.*;
import com.ArkaBrianJSleepRJ.dbjson.JsonAutowired;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value = Payment.class,
            filepath = "C:\\Users\\Arka Brian\\Documents\\Arka\\Kuliah\\UI\\Semester 3\\OOP\\Praktikum\\PraktikumCode\\JSleep\\src\\main\\java\\com\\json\\payment.json")
    public static JsonTable<Payment> paymentTable;

    @GetMapping
    String index() {
        return "payment page";
    }

    /**
     * Creates a payment object based on the given parameters.
     * @param buyerId ID of the buyer
     * @param renterId ID of the renter
     * @param roomId ID of the room
     * @param from start date of the payment
     * @param to end date of the payment
     * @return the created Payment object
     * @throws ParseException if the given dates are not in the expected format
     */
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if(account == null) return null;
        if(room == null) return null;
        if(account.balance <= room.price.price) return null;
        if(!Payment.availability(fromDate, toDate, room)) return null;


        double price = room.price.price;
        Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
        account.balance -= price;
        payment.status = Invoice.PaymentStatus.WAITING;
        if(Payment.makeBooking(fromDate, toDate, room)){
            paymentTable.add(payment);
            return payment;
        }
        else return null;
    }

    /**
     * Accepts a payment with the given ID.
     * @param id ID of the payment to accept
     * @return true if the payment was successfully accepted, false otherwise
     */
    @PostMapping("/{id}/accept")
    public boolean accept( @PathVariable int id ){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment == null ) return false;
        if(payment.status == Invoice.PaymentStatus.WAITING) return false;
        payment.status = Invoice.PaymentStatus.SUCCESS;
        return true;
    }

    /**
     * Cancel a payment with the given ID.
     * @param id ID of the payment to accept
     * @return true if the payment was successfully accepted, false otherwise
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id ){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment == null) return false;
        if(payment.status != Invoice.PaymentStatus.WAITING) return false;

        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
        payment.status = Invoice.PaymentStatus.FAILED;
        buyer.balance += room.price.price;
        return true;

    }

    @PostMapping("/{id}/submit")
    public boolean submit(@RequestParam int id){
        return false;
    }

    @GetMapping("/getAllOrder/{id}")
    List<Payment> getAllOrder(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Payment>paginate(getJsonTable(), page, pageSize, pred -> pred.buyerId == id);
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
