package com.ArkaBrianJSleepRJ;

public class Rating {
    private long total;
    private long count;

    public Rating(){
        this.count = 0;
        this.total = 0;
    }

    public long getTotal() {
        return total;
    }
    public long getCount() {
        return count;
    }

    public void insert(int rating){
        this.total += rating;
        this.count++;
    }

    public double getAverage(){
        if(this.count == 0) return 0;
        return (double)this.total/(double)this.count;
    }

    @Override
    public String toString() {
        return "Rating{\n" +
               "\ttotal=" + this.total + '\n' +
               "\tcount=" + this.count + '\n' +
               '}';
    }
}
