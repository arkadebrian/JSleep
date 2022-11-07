package com.ArkaBrianJSleepRJ;

import java.util.HashMap;

/**This class will be the parent of a lot of other classes*/
public class Serializable {
    /**To identify anything, something must have an ID*/
    final public int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    /**So, ID will be inherited to a lot of other classes*/
    protected Serializable() {
        Integer temp = mapCounter.get(this.getClass());
        if(temp == null){
            temp = 0;
        }
        else temp++;
        mapCounter.put(this.getClass(), temp);
        this.id = temp;
    }

    public int compareTo(Serializable s){
        return this.id - s.id;
    }

    public boolean equals(Object obj){
        return obj instanceof Serializable && this.id == ((Serializable) obj).id;
    }

    public boolean equals(Serializable o) {
        return this.id == o.id;
    }

    public static <T> Integer getClosingId(Class<T> tClass){
        return mapCounter.get(tClass);
    }

    public static <T> Integer setClosingId(Class<T> tClass, int id){
        return mapCounter.put(tClass, id);
    }

}
