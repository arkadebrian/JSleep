package ArkaBrianJSleepRJ;

public class Renter extends Serializable{
    public int phoneNumber;
    public String address;
    public String username;

    public Renter(String username) {
        this.username = username;
        this.phoneNumber = 0;
        this.address = "";
    }

    public Renter(String username, String address) {
        this.username = username;
        this.phoneNumber = 0;
        this.address = address;
    }

    public Renter(String username, int phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }

    public Renter(String username, int phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
