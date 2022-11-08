package com.ArkaBrianJSleepRJ;

import com.ArkaBrianJSleepRJ.dbjson.Serializable;

public class Account extends Serializable {
    public String name;
    public String email;
    public String password;
    public double balance;
    public Renter renter;
    final public static String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    final public static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    
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
