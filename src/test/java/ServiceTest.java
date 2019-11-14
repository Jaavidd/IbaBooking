import booking.service.Client;
import booking.service.Service;
import flights.Flight;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ServiceTest {

    Service service=new Service();


    @Test
    void cancelBooking() throws ParseException {
        Client client = new Client("Javid", "Mammadli");
        Map<Integer, Client> map=new HashMap<>();
        map.put(10,client);
        String start= "10:30 21/12/2019";
        String end = "10:30 21/12/2019";

        Flight flight = new Flight(2, 100, start, end, "London", "New-York");

        assertEquals(false,service.cancelBooking(client,2));

        client.addFlight(flight);
        assertEquals(true,service.cancelBooking(client,2));

    }

    @Test
    void equals() {
        Client client1=new Client("Dexter","Johnson");
        Client client2=new Client("Sasha","Petrov");

        assertEquals(false,client1.equals(client2));

        Client client3=new Client("Dexter","Johnson");
        assertEquals(false,client1.equals(client3));
    }

    @Test
    void get() throws IOException, ClassNotFoundException {
        Client client=new Client("Petr","Mitrich");
        assertNull(service.service.get(2));
    }



}