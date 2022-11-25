package com.ArkaBrianJSleepRJ.controller;

import com.ArkaBrianJSleepRJ.*;
import com.ArkaBrianJSleepRJ.dbjson.JsonAutowired;
import com.ArkaBrianJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class,
            filepath = "C:\\Users\\Arka Brian\\Documents\\Arka\\Kuliah\\UI\\Semester 3\\OOP\\Praktikum\\PraktikumCode\\JSleep\\src\\main\\java\\com\\json\\room.json")
    public static JsonTable<Room> roomTable;

    @GetMapping
    String index() {
        return "room page";
    }

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
            ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null) return null;
        Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
        roomTable.add(room);
        return room;

    }
}