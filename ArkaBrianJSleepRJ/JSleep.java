                                                                                                                                                                                                       package ArkaBrianJSleepRJ;

/*
 * By: Arka Brian Dewara (2106731421)
*/

public class JSleep
{

    public static void main(String[] args) {
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
                Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
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

//    public static Room createRoom(){
//        Price price = new Price(100000, 5);
//        return new Room("hotel", 30, price, Facility.AC);
//    }

}
