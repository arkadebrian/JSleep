package ArkaBrianJSleepRJ;

public class Account extends Serializable{
    public String name;
    public String email;
    public String password;
    
    /**Constructor that uses ID, Name, Email, and Password*/
    public Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
