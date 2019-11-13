package booking.service;

import flights.Flight;

import java.io.Serializable;
import java.util.*;

public class Client implements Serializable {
    private int UserId;


    private String name;
    private String surname;
    private List<Flight> MyFlights=new ArrayList<>();
    private Random rand=new Random();

    public List<Flight> getMyFlights() {
        return MyFlights;
    }



    public Client(String name, String surname) {
        this.name = name;
        this.surname=surname;
        this.UserId=rand.nextInt(1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || this.hashCode()!=o.hashCode()) return false;
        Client client = (Client) o;
        return UserId == client.UserId &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(MyFlights, client.MyFlights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, name, surname, MyFlights, rand);
    }

    @Override


    public String toString() {
        return "Client{" +
                "UserId=" + UserId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", MyFlights=" + MyFlights +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void addFlight(Flight flight)
    {
        MyFlights.add(flight); /** Todo **/
    }

    public boolean cancelFlight(Flight flight)
    {
        try {
            MyFlights.remove(flight);
            return true;
        }catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getUserId() {
        return UserId;
    }
}
