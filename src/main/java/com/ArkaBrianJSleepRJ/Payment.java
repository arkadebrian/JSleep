package com.ArkaBrianJSleepRJ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice {
    public Date to;
    public Date from;
    private int roomId;
    
    /** Constructor to take ID, Buyer ID, Renter ID, time, Room ID, From, and To */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /** Constructor to take ID, Buyer Object, Renter Object, time, Room ID, From, and To*/
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
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

    /**This will return the current time in dd MMMM yyyy format*/
    public String getTime(){
        SimpleDateFormat formattedTime = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = formattedTime.format(this.time.getTime());
        return "Formatted Date = " + strDate;
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(to.before(from))
            return false;

        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                Calendar c = Calendar.getInstance();
                c.setTime(from);
                c.add(Calendar.DATE, 1);
                from = c.getTime();
            }
            return true;
        }
        return false;
    }

    public static boolean availability(Date from, Date to, Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);

        if(start.after(end) || start.equals(end))
            return false;

        if(room.booked.isEmpty()){
            return true;
        }

        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date))
                return false;
        }

        return true;
    }

}
