package com.ArkaBrianJSleepRJ;

public class Account extends Serializable{
    public String name;
    public String email;
    public String password;
    final public static String REGEX_EMAIL = "^[a-zA_Z0-9]+@[a-zA-Z.]+.[a-zA-Z.][a-zA-Z]$";
    final public static String REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    
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

    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }

}
