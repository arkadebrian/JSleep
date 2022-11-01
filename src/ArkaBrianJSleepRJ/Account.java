package ArkaBrianJSleepRJ;

public class Account extends Serializable{
    public String name;
    public String email;
    public String password;
    
    /**Constructor that uses ID, Name, Email, and Password*/
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "Account{\n" +
               "\tname='" + this.name + '\n' +
               "\temail='" + this.email + '\n' +
               "\tpassword='" + this.password + '\n' +
               '}';
    }

}