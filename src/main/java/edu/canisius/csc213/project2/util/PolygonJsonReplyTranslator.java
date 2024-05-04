package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        ObjectMapper objectmapper = new ObjectMapper();

        JsonNode r = objectmapper.readTree(json);
        JsonNode results = r.path("results").path(0);

        String symbol = r.path("ticker").asText();
        double closeprice = results.path("c").asDouble();
        double highestprice = results.path("h").asDouble();
        double lowestprice = results.path("l").asDouble();
        int numtrans = results.path("n").asInt();
        double openprice = results.path("o").asDouble();
        long timestamp = results.path("t").asLong();
        double tradingvolume = results.path("v").asDouble();

        return new StockQuote(symbol, closeprice, highestprice, lowestprice, numtrans, openprice, timestamp, tradingvolume);
    }
}
