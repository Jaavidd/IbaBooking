package flights;

import java.util.Date;
import java.util.HashMap;

public class FlightBuilder {
    private int id;
    private int numberOfSeats;
    private HashMap<Integer, Client> seats;

    private Date startingDate;

    private Date destinationDate;

    private Cities startingCity;
    private Cities destinationCity;

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

    public FlightBuilder withStartingDate(Date startingD) {
        startingDate = startingD;
        return this;
    }

    public FlightBuilder withDestinationDate(Date destinationD) {
        destinationDate = destinationD;
        return this;
    }

    public FlightBuilder withStartingCity(Cities startingPoint) {
        startingCity = startingCity;
        return this;
    }

    public FlightBuilder withDestinationCity(Cities destinationPoint) {
        destinationCity = destinationPoint;
        return this;
    }

    public Flight build() {
        return new Flight(id, numberOfSeats, seats, startingDate, destinationDate, startingCity, destinationCity);
    }
}
