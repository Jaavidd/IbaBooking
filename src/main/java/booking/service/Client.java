package booking.service;

import java.util.List;
import java.util.Objects;

public class Client {
    private int UserId;
    private String name;
    private String surname;
    private static int CounterOfId=0;
    private List<String> MyFlights;

    public List<String> getMyFlights() {
        return MyFlights;
    }



    public Client(String name, String surname, List<String> MyFlights) { //don't need List in constructor (Aleksey)
        this.name = name;
        this.surname=surname;
        this.MyFlights=MyFlights;
        this.UserId=CounterOfId++; // how this will work? can u change this to random value (but it must be unique for each client)? (Aleksey) 
    }

    @Override
    public boolean equals(Object o) { //add comparing by HashCode (Aleksey)
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

    public void AddFlight(Flight flight)
    {
        MyFlights.add(flight); /** Todo **/
    }

    public boolean CancelFlight(Flight flight)
    {
        try {
            MyFlights.remove(flight);  /** TODO **/
            return true;
        }catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getUserId() {
        return UserId;
    }
}
