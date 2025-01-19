package edu.neu.csye7374;

public class NetflixStock extends StockAPI {

    public NetflixStock(String name, double price, String description) {
        super(name, price, description);
    }
    @Override
    public void setPrice(double price) {
        if(price> this.getPrice()) {
            int value = (int) ((price-this.getPrice())*100/this.getPrice());
            setMetric(this.getMetric() +value);
        }else {
            int value = (int) ((price-this.getPrice())*10/this.getPrice());
            setMetric(this.getMetric() +value);
        }
        this.price = price;
    }
}
