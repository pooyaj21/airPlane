package app;

public enum FlightType {
    FIRST_CLASS("First Class", 3025),
    ECONOMY_PLUS("Economy plus", 1150),
    ECONOMY("Economy", 392);
    private final String name;
    private int price;

    FlightType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
