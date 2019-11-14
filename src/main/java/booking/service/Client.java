package booking.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

//import java.util.*;

public class Client {
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


    public void addFlight(Flight flight) {
        MyFlights.add(flight);  /** Todo **/

    }

    public boolean cancelFlight(Flight flight)
    {
        if(!MyFlights.contains(flight))
            return false;


        MyFlights.remove(flight);
        return true;

    }

    public int getUserId() {
        return UserId;
    }
}
