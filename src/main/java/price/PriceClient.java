package price;

public class PriceClient {
    private RestEndpoint restEndpoint;

    public PriceClient(RestEndpoint restEndpoint) {
        this.restEndpoint = restEndpoint;
    }

    public void getLatestPrice(String instrument) {
        restEndpoint.publishPrice(instrument);
    }
}