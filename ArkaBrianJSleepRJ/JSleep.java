package ArkaBrianJSleepRJ;

/*
 * By: Arka Brian Dewara (2106731421)
*/

import java.sql.Date;


public class JSleep {
    public static void main(String[] args) {
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end, RoomA));

        System.out.println("Membuat booking dari tanggal 18 hingga 20");
        Date start2 = Date.valueOf("2022-8-15");
        Date end2 = Date.valueOf("2022-8-18");
        System.out.println(Payment.makeBooking(start2, end2, RoomA));

        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-15");
        Date end3 = Date.valueOf("2022-8-18");
        System.out.println(Payment.makeBooking(start3, end3, RoomB));

        System.out.println("Membuat booking dari tanggal 20 hingga 15");
        Date start4 = Date.valueOf("2022-8-20");
        Date end4 = Date.valueOf("2022-8-15");
        System.out.println(Payment.makeBooking(start4, end4, RoomA));
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
