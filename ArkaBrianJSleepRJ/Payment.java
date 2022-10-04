package ArkaBrianJSleepRJ;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice{
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    /** Constructor to take ID, Buyer ID, Renter ID, time, Room ID, From, and To */
    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }

    /** Constructor to take ID, Buyer Object, Renter Object, time, Room ID, From, and To*/
    public Payment(int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
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

    /**This will return the current time in dd MMMM yyyy format*/
    public String getTime(){
        SimpleDateFormat formattedTime = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = formattedTime.format(this.time.getTime());
        return "Formatted Date = " + strDate;
    }

    /**This will return the current time and 2 days later in dd MMMM yyyy format*/
    public String getDuration(){
        SimpleDateFormat formattedTime = new SimpleDateFormat("dd MMMM yyyy");
        String strFrom = formattedTime.format(this.from.getTime());
        String strTo = formattedTime.format(this.to.getTime());

        return strFrom + " - " + strTo;
    }
}
