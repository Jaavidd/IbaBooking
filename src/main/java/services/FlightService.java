package services;

import dao.Dao;
import flights.Cities;
import flights.Flight;
import flights.FlightBuilder;
import storage.StorageFlights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {

    private Dao<Flight> flightDao = new StorageFlights();

    public ArrayList<Flight> getAllFlight() {
        return flightDao.getAll();
    }

    public ArrayList<Flight> getAvailableFlight(String cities, int freeSeats, Date date) { //TODO Date to String
        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> flight.getDestinationCity().equals(cities))
                .filter(flight -> flight.getNumberOfFreeSeats() >= freeSeats)
                .filter(flight -> flight.getDestinationDate() - date.getTime() <= 100000).sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }

    public void addClient(int flightId, Client client) { //TODO replace to flight
        if (flightDao.get(flightId).getNumberOfFreeSeats() > 0) {
            flightDao.get(flightId).getSeats().put(client.getUserId(), client); //
            flightDao.update(flightDao.get(flightId));
            client.addFlight(flightDao.get(flightId));
        } else {
            System.out.println("error"); // TODO change
        }
    }

    public void removeClient(int flightId, Client client) {
        flightDao.get(flightId).getSeats().remove(client.getUserId(), client);//TODO fix HashMap to ArrayList fo correct work
        client.cancelFlight(flightDao.get(flightId));
    }

    public Flight getInfoAboutFlight(int flightId) {
        return flightDao.get(flightId);
    }

    public HashMap<Integer, Client> getPassengers(int flightId) {
        return flightDao.get(flightId).getSeats();
    }


    public void createRandomFlight() {
        Cities city = new Cities();
        Date date = new Date();
        FlightBuilder flightBuilder = new FlightBuilder();
        flightBuilder.withId((int) (Math.random() * 1000000));
        flightBuilder.withStartingCity("Kiev");
        flightBuilder.withDestinationCity(city.getRandomCity());
        flightBuilder.withStartingDate(date.getTime());
        flightBuilder.withDestinationDate(date.getTime() + (long) (Math.random() * 10000) + 10000);
        flightBuilder.withNumberOfSeats(160);
        flightBuilder.withSeats(new HashMap<Integer, Client>());
        Flight flight = flightBuilder.build();
        flightDao.save(flight);
    }
}
