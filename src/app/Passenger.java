package app;

import app.Ticket.Ticket;

public class Passenger {
    private final String name;
    private final int age;
    private final Ticket ticket;

    public Passenger(String name, int age, Ticket ticket) {
        this.name = name;
        this.age = age;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "app.Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ticket=" + ticket +
                '}';
    }
}
