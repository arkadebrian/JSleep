package ArkaBrianJSleepRJ;

public class Room extends Serializable implements FileParser{
    public Price price;
    public String address;
    public int size;
    public Facility facility;
    public BedType bedType;
    public City city;
    public String name;

    public Room(int id, String name, int size, Price price, Facility facility, City city, String address) {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }

    public String toString() {
        return "Room{\n" +
               "\tprice = " + this.price + '\n' +
               "\taddress = " + this.address + '\n' +
               "\tsize = " + this.size + '\n' +
               "\tfacility = " + this.facility + '\n' +
               "\tbedType = " + this.bedType + '\n' +
               "\tcity = " + this.city + '\n' +
               "\tname = " + this.name + '\n' +
               '}';
    }

    @Override
    public Object write() {
        return null;
    }

    @Override
    public boolean read(String arr) {
        return false;
    }

}
