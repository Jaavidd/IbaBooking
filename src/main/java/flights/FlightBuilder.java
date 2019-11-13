package flights;

import booking.service.Client;
import converter.DateConverter;

import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class FlightBuilder {
    private int id;
    private int numberOfSeats;
    private HashMap<Integer, Client> seats;

    private String startingDate;

    private String destinationDate;


    private String startingCity;
    private String destinationCity;

    public FlightBuilder withId(int inputId) {
        id = inputId;
        return this;
    }

    public FlightBuilder withNumberOfSeats(int number) {
        numberOfSeats = number;
        return this;
    }

    public FlightBuilder withSeats(HashMap<Integer, Client> seatsMap) {
        seats = seatsMap;
        return this;
    }

    public FlightBuilder withStartingDate(String startingD) {

        startingDate = startingD;
        return this;
    }

    public FlightBuilder withDestinationDate(String destinationD) {

        destinationDate = destinationD;
        return this;
    }

    public FlightBuilder withStartingCity(String startingPoint) {
        startingCity = startingCity;
        return this;
    }

    public FlightBuilder withDestinationCity(String destinationPoint) {
        destinationCity = destinationPoint;
        return this;
    }

    public Flight build() throws ParseException {

        return new Flight(id, numberOfSeats, seats, startingDate, destinationDate, startingCity, destinationCity);
    }
}
