package ArkaBrianJSleepRJ;

public class Payment extends Invoice{
    public String to;
    public String from;
    private int roomId;
    
    /** Constructor to take ID, Buyer ID, Renter ID, time, Room ID, From, and To */
    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to) {
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /** Constructor to take ID, Buyer Object, Renter Object, time, Room ID, From, and To*/
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to) {
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**This method will return the string which contains all attributes in this class*/
    public String print(){
        return "Room ID : " + this.roomId  +
             "\nTo      : " + this.to +
             "\nFrom    : " + this.from;
    }

    /**Get the Room ID since it is private in the beginning*/
    public int getRoomId() {
        return this.roomId;
    }
}
