package ArkaBrianJSleepRJ;

public class Price {
//    public double rebate;
    public double price;
    public double discount;

    public Price(double price) {
        this.price = price;
        this.discount = 0;
//        this.rebate = 0;
    }

    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
//        this.rebate = 0;
    }

//    public Price(double price, double rebate) {
//        this.price = price;
//        this.rebate = rebate;
//        this.discount = 0;
//    }

//    public double getRebate() {
//        return rebate;
//    }
//    public void setRebate(double rebate) {
//        this.rebate = rebate;
//    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

//    private double getDiscountedPrice(){
//        if(this.discount > 100) this.discount = 100;
//
//        return this.price - (this.price*(((double)this.discount)/100));
//    }

//    private double getRebatedPrice(){
//        if(this.rebate > this.price){
//            this.rebate = this.price;
//        }
//        return this.price - this.rebate;
//    }
}
