package app.Ticket;

import app.FlightType;

public class Ticket {
    private static int counter = 1;
    private final String id;
    private final String position;
    private final String date;
    private final int jumpTime;
    private final int Price;
    private final FlightType flightType;

    public Ticket(String id, String position, String date, int jumpTime, FlightType flightType) {
        this.flightType = flightType;
        this.id = "T" + counter;
        this.position = position;
        this.date = date;
        this.jumpTime = jumpTime;
        this.Price = flightType.getPrice();
        counter++;
    }

    public String getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getDate() {
        return date;
    }

    public int getJumpTime() {
        return jumpTime;
    }

    public int getPrice() {
        return Price;
    }

    public FlightType flightType() {
        return flightType;
    }

    @Override
    public String toString() {
        return "app.Ticket.Ticket{" +
                "id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", date='" + date + '\'' +
                ", jumpTime=" + jumpTime +
                ", Price=" + Price +
                ", ticketType=" + flightType +
                '}';
    }
}
