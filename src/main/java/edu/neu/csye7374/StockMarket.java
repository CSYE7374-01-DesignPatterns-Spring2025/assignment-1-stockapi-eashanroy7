package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private List<StockAPI> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public void showAllStocks() {
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }

    public void tradeStocks(String name, String bid) {
        for (StockAPI stock : stocks) {
            if(stock.getName().equals(name))
                stock.setBid(bid);
        }
    }

    public void removeStock(String name) {
        int index = -1;
        for (int i=0;i < stocks.size();i++) {
            if(stocks.get(i).getName().equals(name))
                index = i;
        }
        if(index!=-1)
            stocks.remove(index);
    }

    public void startTrading() {

        System.out.println("Trading starts  here");

        this.addStock(new NetflixStock("NetflixStock", 50, "This is the stock for Netflix"));
        this.addStock(new GoogleStock("GoogleStock", 150, "This is the stock for Google/Alphabet LLC"));
        System.out.println("All  the stocks available in the stock market at the start");
        showAllStocks();

        tradeStocks("NetflixStock", "35");
        tradeStocks("GoogleStock", "145");
        System.out.println("Current status of the Stocks in the stock market after bid one");
        showAllStocks();
        tradeStocks("NetflixStock", "39");
        tradeStocks("GoogleStock", "129");
        System.out.println("Current status of the Stocks in the stock market after bid two");
        showAllStocks();
        tradeStocks("NetflixStock", "29");
        tradeStocks("GoogleStock", "159");
        System.out.println("Current status of the Stocks in the stock market after bid three");
        showAllStocks();
        tradeStocks("NetflixStock", "42");
        tradeStocks("GoogleStock", "167");
        System.out.println("Current status of the Stocks in the stock market after bid four");
        showAllStocks();
        tradeStocks("NetflixStock", "39");
        tradeStocks("GoogleStock", "170");
        System.out.println("Current status of the Stocks in the stock market after bid five");
        showAllStocks();
        tradeStocks("NetflixStock", "36");
        tradeStocks("GoogleStock", "150");
        System.out.println("Current status of the Stocks in the stock market after bid six");
        showAllStocks();
        showAllStocks();

        removeStock("NetflixStock");
        System.out.println("Stocks available in the stock market after removing a stock");
        showAllStocks();
    }


}
