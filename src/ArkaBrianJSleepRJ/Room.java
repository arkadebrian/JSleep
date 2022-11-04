package ArkaBrianJSleepRJ;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable{
    public Price price;
    public String address;
    public int size;
    public int accountId;
    public Facility facility;
    public BedType bedType;
    public City city;
    public String name;
    public ArrayList<Date> booked;
    public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address) {
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<>();
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
