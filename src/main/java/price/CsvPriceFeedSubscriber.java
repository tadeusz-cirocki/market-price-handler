package price;

import price.interfaces.MarketPriceSubscriber;

public class CsvPriceFeedSubscriber implements MarketPriceSubscriber {
    private PriceStore priceStore;

    public CsvPriceFeedSubscriber(PriceStore priceStore) {
        this.priceStore = priceStore;
    }

    @Override
    public void onMessage(String message) {
        String[] fields = message.split(",");
        int id = Integer.parseInt(fields[0].trim());
        String instrument = fields[1].trim();
        double bid = Double.parseDouble(fields[2].trim());
        double ask = Double.parseDouble(fields[3].trim());
        String timestamp = fields[4].trim();

        Price price = new Price(id, instrument, bid, ask, timestamp);
        price.adjustPriceByMargin();
        priceStore.addPrice(price);
    }
}
