package app.staff;

public class FlightAttendant extends Crew {
    public FlightAttendant(String name, int age) {
        super(name, age, 71000);
    }

    @Override
    public String toString() {
        return "flightAttendant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
