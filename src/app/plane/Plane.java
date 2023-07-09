package app.plane;

import app.FlightType;
import app.staff.FirstOfficerPilot;
import app.staff.FirstPilot;
import app.staff.FlightAttendant;

import java.util.ArrayList;

public class Plane {
    private final String name;
    private final ArrayList<Seat> seats = new ArrayList<>();
    private String startCity;
    private String endCity;
    private String flightTime;
    private FirstPilot firstPilot;
    private FirstOfficerPilot firstOfficerPilot;
    private ArrayList<FlightAttendant> flightAttendants = new ArrayList<>();

    public Plane(String name, int firstClassCapacity, int economyPlusCapacity, int economyCapacity) {
        this.name = name;
        for (int i = 0; i < firstClassCapacity; i++) {
            seats.add(new Seat("FC" + (i + 1), FlightType.FIRST_CLASS));
        }
        for (int i = 0; i < economyPlusCapacity; i++) {
            seats.add(new Seat("E+" + (i + 1), FlightType.ECONOMY_PLUS));
        }
        for (int i = 0; i < economyCapacity; i++) {
            seats.add(new Seat("E" + (i + 1), FlightType.ECONOMY));
        }
    }

    public String getName() {
        return name;
    }

    public FirstPilot getFirstPilot() {
        return firstPilot;
    }

    public void setFirstPilot(FirstPilot firstPilot) {
        this.firstPilot = firstPilot;
    }

    public FirstOfficerPilot getFirstOfficerPilot() {
        return firstOfficerPilot;
    }

    public void setFirstOfficerPilot(FirstOfficerPilot firstOfficerPilot) {
        this.firstOfficerPilot = firstOfficerPilot;
    }

    public ArrayList<FlightAttendant> getFlightAttendants() {
        return flightAttendants;

    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", firstPilot=" + firstPilot +
                ", firstOfficerPilot=" + firstOfficerPilot +
                ", flightAttendants=" + flightAttendants +
                '}';
    }
}