package ArkaBrianJSleepRJ;

import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {

    private Algorithm(){

    }

    public static <T> int count(Iterator<T> iterator, T value){
        int count = 0;
        while(iterator.hasNext())
            if(iterator.next().equals(value)) count++;
        return count;
    }

    public static <T> int count(T[] array, T value){
        return count(Arrays.asList(array).iterator(), value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> predicate){
        int count = 0;
        for (T t : iterable)
            if(predicate.predicate(t)) count++;

        return count;
    }

    public static <T> int count(T[] array, Predicate<T> predicate){
        return count(Arrays.asList(array).iterator(), predicate);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate){
        int count = 0;
        while(iterator.hasNext())
            if(predicate.predicate(iterator.next())) count++;

        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value){
        return count(iterable.iterator(), value);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)) return true;
        }
        return false;
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred){
        for (T t : array)
            if(pred.predicate(t)) return t;

        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        for (T t : iterable)
            if(pred.predicate(t)) return t;

        return null;
    }

    public static <T> T find(T[] array, T value){
        final Predicate<T> pred = value::equals;
        return find(array, pred);
    }

    public static <T> T find(Iterable<T> iterable, T value){
        final Predicate<T> pred = value::equals;
        return find(iterable, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            T current = iterator.next();

            if(pred.predicate(current))
                return current;

        }
        return null;
    }

}
