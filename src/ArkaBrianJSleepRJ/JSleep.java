package ArkaBrianJSleepRJ;

/*
 * By: Arka Brian Dewara (2106731421)
*/

import java.io.FileWriter;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

public class JSleep {

//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }

    public static void main(String[] args) throws IOException {
//        String filepath = "C:\\Users\\Arka Brian\\Documents\\Arka\\Kuliah\\UI\\Semester 3\\OOP\\Praktikum\\PraktikumCode\\JSleep\\src\\city.json";
//        Gson gson = new Gson();
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name: " + input.name);
//            System.out.println("population: " + input.population);
//            System.out.println("states: ");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }

//        try {
//            String filePath = "src\\json\\randomRoomList.json";
//
//            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filePath);
//            List<Room> filteredRoom = filterByCity(tableRoom, "jakarta", 0, 5);
//            filteredRoom.forEach(room -> System.out.println(room.toString()));
//        }
//        catch (Throwable t){
//            t.printStackTrace();
//        }

        try {
            String filePath = "src\\json\\account.json";

            JsonTable<Account> tableAccount= new JsonTable<>(Account.class, filePath);
            Account akun = new Account("name", "email", "password");
            tableAccount.add(akun);
            tableAccount.writeJson();
        }
        catch (Throwable t){
            t.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            ThreadingObject thread = new ThreadingObject("Thread " + i);
            thread.start();
        }
    }

    public static List<Room> filterByCity(List<Room> rooms, String city, int page, int pageSize){
        return Algorithm.paginate(rooms, page, pageSize, i -> i.city == City.valueOf(city.toUpperCase()));
    }

    public static List<Room> filterByPrice(List<Room> rooms, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(rooms, i -> ((i.price.price >= minPrice) && (i.price.price <= maxPrice)));
    }

    public static List<Room> filterByAccountId(List<Room> account, int accountId, int page, int pageSize){
        return Algorithm.paginate(account, page, pageSize, i -> i.accountId == accountId);
    }

//    static int getHotelId(){
//        return 0;
//    }
//
//    static String getHotelName(){
//        return "hotel";
//    }
//
//    static boolean isDiscount(){
//        return true;
//    }
//
//    static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
//        if(beforeDiscount < afterDiscount){
//            return 0.0f;
//        }
//        float flobef = beforeDiscount;
//        float floaft = afterDiscount;
//        return 100 - ((floaft/flobef)*100);
//    }
//
//    static int getDiscountedPrice(int price, float discountedPercentage){
//        if(discountedPercentage > 100.0f) return 100;
//        float hasil = 1000*((100-discountedPercentage)/100);
//        return (int)hasil;
//    }
//
//    static int getOriginalPrice(int discountedPrice, float discountPercentage){
//        int half = 100 - (int)discountPercentage;
//        return (discountedPrice*100) / half;
//    }
//
//    static float getAdminFeePercentage(int price){
//        return 0.05f;
//    }
//
//    static int getAdminFee(int price){
//        float hasil = price * getAdminFeePercentage(price);
//        return (int)hasil;
//    }
//
//    static int getTotalPrice(int price, int numberOfNight){
//        return (price + getAdminFee(price))*numberOfNight;
//    }

    public static Room createRoom(){
        Price price = new Price(100000, 0.5);
        return new Room(1234,"Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
    }

}
