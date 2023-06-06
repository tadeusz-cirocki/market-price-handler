package price;

import java.util.HashMap;
import java.util.Map;

public class PriceStore {
    private Map<String, Price> priceMap;

    public PriceStore() {
        this.priceMap = new HashMap<>();
    }

    public void addPrice(Price price) {
        priceMap.put(price.getInstrument(), price);
    }

    public Price getPrice(String instrument) {
        return priceMap.get(instrument);
    }
}
