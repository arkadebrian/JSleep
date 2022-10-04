package ArkaBrianJSleepRJ;

public class Voucher extends Serializable implements FileParser{
    public String name;
    public int code;
    public Type type;
    public double minimum;
    public double cut;
    private boolean used;

    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut) {
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = used;
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

    @Override
    public Object write() {
        return null;
    }

    @Override
    public boolean read(String arr) {
        return false;
    }

}
