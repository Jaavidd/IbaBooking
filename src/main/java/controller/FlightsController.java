package controller;

import booking.service.Client;
import flights.Flight;
import services.FlightService;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FlightsController {

    private FlightService flightService = new FlightService();

    public ArrayList<Flight> getAllFlight() throws IOException, ClassNotFoundException {
         return flightService.getAllFlight();
    }

    public ArrayList<Flight> getAvailableFlight(String cities, int freeSeats, Date date) throws IOException, ClassNotFoundException {
        return flightService.getAvailableFlight(cities, freeSeats, date);
    }

    public void addClient(int flightId, Client client) throws IOException, ClassNotFoundException {
        flightService.addClient(flightId, client);
    }

    public void removeClient(int flightId, Client client) throws IOException, ClassNotFoundException {
        flightService.removeClient(flightId, client);
    }

    public Flight getInfoAboutFlight(int flightId) throws IOException, ClassNotFoundException {
        return flightService.getInfoAboutFlight(flightId);
    }
  
    public HashMap<Integer, Client> getPassengers(int flightId) throws IOException, ClassNotFoundException {
        return flightService.getPassengers(flightId);
    }

    public void createRandomFlight() throws ParseException, IOException, ClassNotFoundException {
        flightService.createRandomFlight();
    }

}
