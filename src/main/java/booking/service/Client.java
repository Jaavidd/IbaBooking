package booking.service;

import java.util.List;
import java.util.Objects;

public class Client {
    private int UserId;
    private String name;
    private String surname;
    private static int CounterOfId=0;

    public List<String> getMyFlights() {
        return MyFlights;
    }

    private List<String> MyFlights;



    public Client(String name, String surname, List<String> MyFlights) {
        this.name = name;
        this.surname=surname;
        this.MyFlights=MyFlights;
        this.UserId=CounterOfId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return UserId == client.UserId &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(MyFlights, client.MyFlights);
    }


    public String toString() {
        return "Client{" +
                "UserId=" + UserId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", MyFlights=" + MyFlights +
                '}';
    }

    public int getUserId() {
        return UserId;
    }
}
