package flights;

import dao.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class FlightService {

    private Dao<Flight> flightDao = new StorageFlights();

    public Collection<Flight> getAllFlight(){
        return  flightDao.getAll();
    }

    public ArrayList<Flight> getFlightsWithFreeSeatsMoreThan(int freeSeats){
        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> (flight.getNumberOfSeats() - flight.getSeats()) )
                .size() >= freeSeats).collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }

    public ArrayList<Flight> getFlightsByDestination(Cities cities){
        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> flight.getDestinationCity())
                .equals(cities)).collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }

    public ArrayList<Flight> getAvailableFlight(Cities cities, int freeSeats, Date date){
        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> flight.getDestinationCity().equals(cities))
                .filter(flight -> flight.getNumberOfSeats() - flight.getSeats().size() >= freeSeats)
                .filter(flight -> flight.getDestinationDate().getTime() - date.getTime() <= 100000).sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }
}
