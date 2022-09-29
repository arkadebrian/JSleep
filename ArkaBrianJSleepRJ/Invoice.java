package ArkaBrianJSleepRJ;

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
    public String time;
    public RoomRating rating;
    public PaymentStatus status;

    /**Constructor which uses ID, Buyer ID, Renter ID, and time*/
    protected Invoice(int id, int buyerId, int renterId, String time) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**Constructor which uses ID, Buyer Object, Renter Object, and time*/
    public Invoice(int id, Account buyer, Renter renter, String time) {
        super(id);
        this.time = time;
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
