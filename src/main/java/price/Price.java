package price;

public class Price {
    private int id;
    private String instrument;
    private double bid;
    private double ask;
    private String timestamp;

    public Price(int id, String instrument, double bid, double ask, String timestamp) {
        this.id = id;
        this.instrument = instrument;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public void adjustPriceByMargin() {
        double bidMargin = this.bid * 0.001;
        double askMargin = this.ask * 0.001;
        this.bid -= bidMargin;
        this.ask += askMargin;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", instrument='" + instrument + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
