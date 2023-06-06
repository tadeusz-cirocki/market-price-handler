package price;

import price.interfaces.MarketPriceSubscriber;

public class MarketPriceFeed {
    private MarketPriceSubscriber subscriber;

    public MarketPriceFeed(MarketPriceSubscriber subscriber) {
        this.subscriber = subscriber;
    }

    public void receivePriceFeed(String csvData) {
        String[] messages = csvData.split("\n");
        for (String message : messages) {
            subscriber.onMessage(message);
        }
    }
}
