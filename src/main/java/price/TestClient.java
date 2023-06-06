package price;

public class TestClient 
{
    public static void main( String[] args )
    {
        PriceStore priceStore = new PriceStore();
        CsvPriceFeedSubscriber subscriber = new CsvPriceFeedSubscriber(priceStore);
        MarketPriceFeed priceFeed = new MarketPriceFeed(subscriber);

        // Simulate receiving a CSV price feed
        String csvData = "106, EUR/USD, 1.1000, 1.2000, 01-06-2020 12:01:01:001\n" +
                "107, EUR/JPY, 119.60, 119.90, 01-06-2020 12:01:02:002\n" +
                "108, GBP/USD, 1.2500, 1.2560, 01-06-2020 12:01:02:002\n" +
                "109, GBP/USD, 1.2499, 1.2561, 01-06-2020 12:01:02:100\n" +
                "110, EUR/JPY, 119.61, 119.91, 01-06-2020 12:01:02:110";

        priceFeed.receivePriceFeed(csvData);

        // Test client
        RestEndpoint restEndpoint = new RestEndpoint(priceStore);
        PriceClient priceClient = new PriceClient(restEndpoint);
        priceClient.getLatestPrice("EUR/USD");
        priceClient.getLatestPrice("EUR/JPY");
        priceClient.getLatestPrice("GBP/USD");

        /*
            Output:
            Published price: Price{id=106, instrument='EUR/USD', bid=1.0989, ask=1.2012, timestamp='01-06-2020 12:01:01:001'}
            Published price: Price{id=110, instrument='EUR/JPY', bid=119.49039, ask=120.02991, timestamp='01-06-2020 12:01:02:110'}
            Published price: Price{id=109, instrument='GBP/USD', bid=1.2486501, ask=1.2573561, timestamp='01-06-2020 12:01:02:100'}
        */
    }
}
