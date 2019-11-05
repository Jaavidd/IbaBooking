package services;

import dao.Dao;
import flights.Cities;
import flights.Flight;
import storage.StorageFlights;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FlightService {

    private Dao<Flight> flightDao = new StorageFlights();

    public Collection<Flight> getAllFlight(){
        return  flightDao.getAll();
    }

//    public ArrayList<Flight> getFlightsWithFreeSeatsMoreThan(int freeSeats){
//        ArrayList<Flight> availableFlight;
//        availableFlight = flightDao.getAll().stream()
//                .filter(flight -> flight.getNumberOfSeats() - flight.getSeats()
//                .size() >= freeSeats).collect(Collectors.toCollection(ArrayList::new));
//        return availableFlight;
//    }
//
//    public ArrayList<Flight> getFlightsByDestination(Cities cities){
//        ArrayList<Flight> availableFlight;
//        availableFlight = flightDao.getAll().stream()
//                .filter(flight -> flight.getDestinationCity()
//                .equals(cities)).collect(Collectors.toCollection(ArrayList::new));
//        return availableFlight;
//    }

    public ArrayList<Flight> getAvailableFlight(Cities cities, int freeSeats, Date date){
        ArrayList<Flight> availableFlight;
        availableFlight = flightDao.getAll().stream()
                .filter(flight -> flight.getDestinationCity().equals(cities))
                .filter(flight -> flight.getNumberOfFreeSeats() >= freeSeats)
                .filter(flight -> flight.getDestinationDate().getTime() - date.getTime() <= 100000).sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return availableFlight;
    }

    public void addClient(int flightId, Client client){ //TODO replace to flight
        if(flightDao.get(flightId).get().getNumberOfFreeSeats() > 0) {
            flightDao.get(flightId).get().getSeats().put(client.getId(), client); //
            flightDao.update(flightDao.get(flightId).get());
            client.addFlight(flightDao.get(flightId));
        }else {
            System.out.println("error"); // TODO change
        }
    }

    public void removeClient(int flightId, Client client){
        flightDao.get(flightId).get().getSeats().remove(client.getId(),client);//TODO fix HashMap to ArrayList fo correct work
        client.cancelFlight(flightDao.get(flightId));
    }

    public Flight getInfoAboutFlight(int flightId){
        return flightDao.get(flightId).get();
    }

    public HashMap<Integer, Client> getPassengers(int flightId){
        return flightDao.get(flightId).get().getSeats();
    }



}
