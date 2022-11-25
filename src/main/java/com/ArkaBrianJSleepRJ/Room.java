package com.ArkaBrianJSleepRJ;

import com.ArkaBrianJSleepRJ.BedType;
import com.ArkaBrianJSleepRJ.City;
import com.ArkaBrianJSleepRJ.Facility;
import com.ArkaBrianJSleepRJ.Price;
import com.ArkaBrianJSleepRJ.dbjson.Serializable;

import java.util.*;

public class Room extends Serializable {
    public Price price;
    public String address;
    public int size;
    public int accountId;
    public ArrayList<Facility> facility = new ArrayList<>();
    public BedType bedType;
    public City city;
    public String name;
    public ArrayList<Date> booked;
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility.addAll(facility);
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<Date>();
        this.bedType = bedType;
    }

    public String toString() {
        return "Room{\n" +
               "\taccoudnId = " + this.accountId + '\n' +
               "\tprice = " + this.price + '\n' +
               "\taddress = " + this.address + '\n' +
               "\tsize = " + this.size + '\n' +
               "\tfacility = " + this.facility + '\n' +
               "\tbedType = " + this.bedType + '\n' +
               "\tcity = " + this.city + '\n' +
               "\tname = " + this.name + '\n' +
               "\tID = " + this.id + '\n' +
               '}';
    }

}
