package app.plane;

import app.FlightType;

public class Seat {
    private final String name;
    private final FlightType flightType;

    private boolean isTaken;

    public Seat(String name, FlightType flightType) {
        this.name = name;
        this.flightType = flightType;
    }

    public String getName() {
        return name;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    @Override
    public String toString() {
        return "Seat{" + "name='" + name + '\'' + ", flightType=" + flightType + ", isTaken=" + isTaken + '}';
    }
}
