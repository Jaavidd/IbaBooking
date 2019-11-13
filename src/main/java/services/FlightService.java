package services;
import converter.DateConverter;
import dao.Dao;
import flights.Flight;
import flights.FlightRandomGenerator;
import storage.DataFlight;
import storage.StorageFlights;

import java.io.IOException;
import java.text.ParseException;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {


    private Dao<Flight> flightDao = new StorageFlights();

    public FlightService() throws IOException {
    }

    public ArrayList<Flight> getAllFlight() throws IOException, ClassNotFoundException {
        return flightDao.getAll();
    }

    public ArrayList<Flight> getAvailableFlight(String cities, int freeSeats, Date date) throws IOException, ClassNotFoundException { 

        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> flight.getDestinationCity().equals(cities))
                .filter(flight -> flight.getNumberOfFreeSeats() >= freeSeats)
                .filter(flight -> flight.getDestinationDate() - Calendar.getInstance()
                        .getTimeInMillis() <= DateConverter.hour(24)).sorted()

                .collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }

    public void addClient(int flightId, Client client) throws IOException, ClassNotFoundException { 
        if (flightDao.get(flightId).getNumberOfFreeSeats() > 0) {
            flightDao.get(flightId).getSeats().put(client.getUserId(), client); //
            flightDao.update(flightDao.get(flightId));
            client.addFlight(flightDao.get(flightId));
        } else {
            System.out.println("error"); // TODO change
        }
    }

    public void removeClient(int flightId, Client client) throws IOException, ClassNotFoundException {

        flightDao.get(flightId).getSeats().remove(client.getUserId(), client);//TODO fix HashMap to ArrayList fo correct work
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
