package flights;

import java.util.Date;
import java.util.HashMap;

public class Flight {

    private int id; //TODO change to string , ex -> HE110, JB201
    private int numberOfSeats;

    //TODO change HashMap to ArrayList or create new class "SeatMap"(2d matrix, seat/ client)
    private HashMap<Integer, Client> seats; //TODO max size,  different class. Key - seat number or *clientId*, value - client
    private int numberOfFreeSeats;

    private Date startingDate; //current time + 24h
    private Date destinationDate; // starting time + (flying time)

    private String startingCity; //TODO default Kiev, change String to enum City
    private String destinationCity; //TODO Random cities (create enum)

    public Flight(int id, int numberOfSeats,
                  HashMap<Integer, Client> seats,
                  Date startingDate, Date destinationDate,
                  String startingCity, String destinationPoint) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.seats = seats;
        this.startingDate = startingDate;
        this.destinationDate = destinationDate;
        this.startingCity = startingCity;
        this.destinationCity = destinationPoint;
        this.numberOfFreeSeats = numberOfFreeSeats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("id=").append(id);
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", seats=").append(seats);
//        sb.append(", numberOfFreeSeats=").append(numberOfFreeSeats);
        sb.append(", startingDate=").append(startingDate);
        sb.append(", destinationDate=").append(destinationDate);
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

    public Date getStartingDate() {
        return startingDate;
    }

    public Date getDestinationDate() {
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
