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

    /**
     * Handles HTTP GET requests to retrieve a list of rooms rented by a specific renter.
     *
     * @param id the ID of the renter.
     * @param page the page number for pagination.
     * @param pageSize the number of items per page.
     *
     * @return a list of rooms rented by the specified renter matching the specified pagination criteria.
     */
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

    /**
     * Handles HTTP POST requests to create a new room.
     *
     * @param accountId the ID of the account that will own the room.
     * @param name the name of the room.
     * @param size the size of the room.
     * @param price the price of the room.
     * @param facility a list of facilities available in the room.
     * @param city the city where the room is located.
     * @param address the address of the room.
     * @param bedType the type of bed in the room.
     *
     * @return the newly created room, or `null` if the specified account does not exist or is not a renter.
     */
    @PostMapping("/createRoom")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam double price,
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

    /**
     * Handles HTTP GET requests to retrieve a list of rooms.
     *
     * @param page the page number for pagination.
     * @param pageSize the number of items per page.
     *
     * @return a list of rooms matching the specified pagination criteria.
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
