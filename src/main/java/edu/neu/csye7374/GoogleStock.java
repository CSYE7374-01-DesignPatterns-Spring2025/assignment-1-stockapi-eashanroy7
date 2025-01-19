package edu.neu.csye7374;

public class GoogleStock extends StockAPI{
    public GoogleStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setPrice(double price) {
        if(price> this.getPrice()) {
            int value = (int) ((price-this.getPrice())*1.5/this.getPrice());
            setMetric(this.getMetric() +value);
        }else {
            int value = (int) ((price-this.getPrice())*0.9/this.getPrice());
            setMetric(this.getMetric() +value);
        }
        this.price = price;
    }

}
