package edu.canisius.csc213.project2.quotes;

public class StockQuote {
    private String symbol;
    private double closeprice;
    private double highestprice;
    private double lowestprice;
    private int numtrans;
    private double openprice;
    private long timestamp;
    private double tradingvolume;


    public StockQuote (String symbol, double closeprice, double highestprice, double lowestprice, int numtrans, double openprice, long timestamp, double tradingvolume) {
        this.symbol = symbol;
        this.closeprice = closeprice;
        this.highestprice = highestprice;
        this.lowestprice = lowestprice;
        this.numtrans = numtrans;
        this.openprice = openprice;
        this.timestamp = timestamp;
        this.tradingvolume = tradingvolume;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getClosePrice() {
        return closeprice;
    }

    public double getHighestPrice() {
        return highestprice;
    }

    public double getLowestPrice() {
        return lowestprice;
    }

    public int getNumberOfTransactions() {
        return numtrans;
    }

    public double getOpenPrice() {
        return openprice;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getTradingVolume() {
        return tradingvolume;
    }

    public String prettyPrint() {
        return "Symbol: " + symbol + "\n" + 
        "Close Price: " + closeprice + "\n" + 
        "Highest Price:" + highestprice + "\n" +
        "Lowest Price: " + lowestprice + "\n" +
        "Number of Transactions: " + numtrans + "\n" +
        "Open Price: " + openprice + "\n" +
        "Trading Volume: " + tradingvolume + "\n";
    }
}
