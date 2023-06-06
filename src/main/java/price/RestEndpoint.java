package price;

public class RestEndpoint {
    private PriceStore priceStore;

    public RestEndpoint(PriceStore priceStore) {
        this.priceStore = priceStore;
    }

    public void publishPrice(String instrument) {
        Price price = priceStore.getPrice(instrument);
        // Publish the price to the REST endpoint
        System.out.println("Published price: " + price.toString());
    }
}
