package app.staff;

public class FirstOfficerPilot extends Crew {
    public FirstOfficerPilot(String name, int age) {
        super(name, age, 74000);
    }

    @Override
    public String toString() {
        return "FirstOfficerPilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
