package ArkaBrianJSleepRJ;

import java.util.ArrayList;

public class Validate{
    
    /**This method will filter the given Price Objects according to the boolen value. If it is true, then it will filter the prices that are less or equal than given value*/
    public static ArrayList<Double> filter(Price[] list, int value, boolean less){
        ArrayList<Double> returned = new ArrayList<>();
        if(less){
            for (Price i : list) {
                if(i.price <= value){
                    returned.add(i.price);
                }
            }
        }

        else{
            for (Price i : list) {
                if(i.price > value){
                    returned.add(i.price);
                }
            }
        }
        return returned;
    }

}
