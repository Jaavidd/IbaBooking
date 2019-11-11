package flights;


import converter.DateConverter;

import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;

public class Flight implements Serializable {

    private int id; //TODO change to string , ex -> HE110, JB201
    private int numberOfSeats;

    //TODO change HashMap to ArrayList or create new class "SeatMap"(2d matrix, seat/ client)
    private int numberOfFreeSeats;
    private HashMap<Integer, Client> seats = new HashMap<Integer, Client>(numberOfSeats); //TODO max size,  different class. Key - seat number or *clientId*, value - client


    private long startingDate; //current time + 24h
    private long destinationDate; // starting time + (flying time)

    private String startingCity; //TODO default Kiev, change String to enum City
    private String destinationCity; //TODO Random cities (create enum)

    public Flight(int id, int numberOfSeats,
                  HashMap<Integer, Client> seats,
                  String startingDate, String destinationDate,
                  String startingCity, String destinationPoint) throws ParseException {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.seats = seats;
        this.startingDate = DateConverter.stringToMills(startingDate);
        this.destinationDate = DateConverter.stringToMills(destinationDate);
        this.startingCity = startingCity;
        this.destinationCity = destinationPoint;
        this.numberOfFreeSeats = numberOfFreeSeats;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("id=").append(id);
        sb.append(", number of seats=").append(numberOfSeats);
        sb.append(", seats=").append(seats);
        sb.append(", numberOfFreeSeats=").append(numberOfFreeSeats);
        sb.append(", startingDate = ").append(DateConverter.millsToString(startingDate)); //Done
        sb.append(", destinationDate = ").append(DateConverter.millsToString(destinationDate)); //Done
        sb.append(", startingCity='").append(startingCity).append('\'');
        sb.append(", destinationCity='").append(destinationCity).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public HashMap<Integer, Client> getSeats() {
        return seats;
    }

    public Long getStartingDate() {
        return startingDate;
    }

    public Long getDestinationDate() {
        return destinationDate;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public int getNumberOfFreeSeats() {
        numberOfFreeSeats = numberOfSeats - seats.size();
        return numberOfFreeSeats;
    }
}
