package app.staff;

public class FirstPilot extends Crew{
    public FirstPilot(String name, int age) {
        super(name, age, 97000);
    }

    @Override
    public String toString() {
        return "FirstPilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
