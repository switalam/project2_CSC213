package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{

    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);

    }

    public static String sendGetRequest(String endpointUrl) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(endpointUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
            throw new IOException("Failed to send GET request. Response code: " + responseCode);
        }

        return response.toString();
    
    }
    

    public String getEndpointUrl(String symbolName, String date, String apiKey) {
        try {
            java.time.LocalDate.parse(date);
        } catch (java.time.format.DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + date);
        }
        try {
            return new URL("https", "api.polygon.io", "/v2/aggs/ticker/" + symbolName + "/range/1/day/" + date + "/" + date)
                    .toURI()
                    .toString() + "?apiKey=" + apiKey;
        } catch (URISyntaxException | IOException e) {
            throw new IllegalArgumentException("Invalid URL components: " + e.getMessage());
        }
    }



}
