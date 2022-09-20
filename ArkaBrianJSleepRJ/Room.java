package ArkaBrianJSleepRJ;

public class Room {
    public String name;
    public int size;
    public Facility facility;
    public Price price;

    public Room(String name, int size, Price price, Facility facility) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }

}
