package ArkaBrianJSleepRJ;

public class Voucher {
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(String name, int code, Type type, double minimum, double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = false;
    }

    public boolean isUsed() {
        return this.used;
    }

    public boolean canApply(Price price){
        return (price.price > this.minimum) && (!this.used);
    }

    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            if(this.cut > 100) this.cut = 100;
            return price.price - (price.price*(this.cut/100));
        }
        else  {
            if(this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }

    }

}
