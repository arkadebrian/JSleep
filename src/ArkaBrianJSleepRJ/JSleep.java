package ArkaBrianJSleepRJ;

/*
 * By: Arka Brian Dewara (2106731421)
*/

import java.sql.Date;


public class JSleep {
    public static void main(String[] args) {
        System.err.println("Hello from IntelliJ!");
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
        Price price = new Price(100000, 5);
        return new Room(30, "hotel", 3, price, Facility.Balcony, City.JAKARTA, "Jl. Jalan");
    }

}
