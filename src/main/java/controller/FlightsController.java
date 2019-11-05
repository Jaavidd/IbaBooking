package controller;

import flights.Flight;
import services.FlightService;

import java.util.ArrayList;
import java.util.Date;

public class FlightsController {

    FlightService flightService = new FlightService();

    public ArrayList<Flight> getAllFlight(){
         return flightService.getAllFlight();
    }

    public ArrayList<Flight> getAvailableFlight(String cities, int freeSeats, Date date){
        return flightService.getAvailableFlight(cities, freeSeats, date);
    }

    public void addClient(int flightId, Client client){
        flightService.addClient(flightId, client);
    }

    public void removeClient(int flightId, Client client){
        flightService.removeClient(flightId, client);
    }

    public Flight getInfoAboutFlight(int flightId){
        return flightService.getInfoAboutFlight(flightId);
    }

    public void createRandomFlight(){
        flightService.createRandomFlight();
    }

}
