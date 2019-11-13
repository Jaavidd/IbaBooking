package booking;

import booking.controller.Controller;
import booking.service.Client;
import controller.FlightsController;
import flights.Flight;
import flights.FlightRandomGenerator;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        FlightsController flightsController = new FlightsController();
        FlightRandomGenerator flightRandomGenerator = new FlightRandomGenerator();
        Flight flight = flightRandomGenerator.buildRandom();
        Flight flight1 = flightRandomGenerator.buildRandom();
        flightsController.addFlight(flight);
        flightsController.addFlight(flight1);

        System.out.println(flightsController.getAllFlight());
    }
}

