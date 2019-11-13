package flights;

import booking.service.Client;
import converter.DateConverter;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class FlightRandomGenerator {
    private int id;
    private int numberOfSeats;
    private HashMap<Integer, Client> seats;

    private String startingDate;

    private String destinationDate;

    private String startingCity;
    private String destinationCity;

    private FlightRandomGenerator withId() {
        id = (int) (Math.random() * 1000000);
        return this;
    }

    private FlightRandomGenerator withNumberOfSeats() {
        numberOfSeats = 80;
        return this;
    }

    private FlightRandomGenerator withSeats() {
        seats = new HashMap<Integer, Client>(numberOfSeats);
        return this;
    }

    private FlightRandomGenerator withStartingDate() {
        startingDate = DateConverter.millsToString((long) (Calendar.getInstance().getTimeInMillis() + (DateConverter.hour(24) * Math.random())));
        return this;
    }

    private FlightRandomGenerator withDestinationDate() throws ParseException {
        destinationDate = DateConverter.millsToString(DateConverter.stringToMills(startingDate) +  + DateConverter.hour(3));
        return this;
    }

    private FlightRandomGenerator withStartingCity() {
        Cities startingPoint = new Cities();
        startingCity = startingPoint.getRandomCity();
        return this;
    }

    private FlightRandomGenerator withDestinationCity() {
        Cities destinationPoint = new Cities();
        destinationCity = destinationPoint.getRandomCity();
        return this;
    }

    public Flight buildRandom() throws ParseException {
        withId();
        withNumberOfSeats();
        withSeats();
        withStartingDate();
        withDestinationDate();
        withStartingCity();
        withDestinationCity();
        return new Flight(id, numberOfSeats, seats, startingDate, destinationDate, startingCity, destinationCity);
    }
}
