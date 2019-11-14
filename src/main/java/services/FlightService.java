package services;
import booking.service.Client;
import converter.DateConverter;
import dao.Dao;
import flights.Flight;
import flights.FlightRandomGenerator;
import storage.StorageFlights;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class FlightService {

    private Dao<Flight> flightDao = new StorageFlights();;

    public ArrayList<Flight> getAllFlight() throws IOException, ClassNotFoundException {
        return flightDao.getAll();
    }

    public ArrayList<Flight> getAvailableFlight(String cities, int freeSeats, Date date) throws IOException, ClassNotFoundException {
        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> flight.getDestinationCity().equals(cities))
                .filter(flight -> flight.getNumberOfFreeSeats() >= freeSeats)
                .filter(flight -> date.getTime() + DateConverter.hour(12) >= flight.getDestinationDate()).sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }

    public void addClient(int flightId, Client client) throws IOException, ClassNotFoundException {
        if (flightDao.get(flightId).getNumberOfFreeSeats() > 0) {
            flightDao.get(flightId).getSeats().put(client.getUserId(), client);
            flightDao.update(flightDao.get(flightId));
            client.addFlight(flightDao.get(flightId));
        } else {
            System.out.println("add client error");
        }
    }

    public void removeClient(int flightId, Client client) throws IOException, ClassNotFoundException {
        flightDao.get(flightId).getSeats().remove(client.getUserId(), client);
        client.cancelFlight(flightDao.get(flightId));
    }

    public Flight getInfoAboutFlight(int flightId) throws IOException, ClassNotFoundException {
        return flightDao.get(flightId);
    }

    public HashMap<Integer, Client> getPassengers(int flightId) throws IOException, ClassNotFoundException {
        return flightDao.get(flightId).getSeats();
    }

    public void createRandomFlight() throws ParseException, IOException, ClassNotFoundException {
        FlightRandomGenerator flightRandom = new FlightRandomGenerator();
        flightDao.save(flightRandom.buildRandom());
    }
}
