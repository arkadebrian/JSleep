package ArkaBrianJSleepRJ;

import java.util.Calendar;
import java.util.Date;

public class Invoice extends Serializable{
    public enum RoomRating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public enum PaymentStatus{
        FAILED,
        WAITING,
        SUCCESS
    }

    public int buyerId;
    public int renterId;
    public Date time;
    public RoomRating rating;
    public PaymentStatus status;

    /**Constructor which uses ID, Buyer ID, Renter ID, and time*/
    protected Invoice(int id, int buyerId, int renterId) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**Constructor which uses ID, Buyer Object, Renter Object, and time*/
    public Invoice(int id, Account buyer, Renter renter) {
        super(id);
        this.time = new Date();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**This method will return the string which contains all attributes in this class*/
    public String print(){
        return "Buyer  ID : " + this.buyerId  +
             "\nRenter ID : " + this.renterId +
             "\nTime      : " + this.time;
    }

}
