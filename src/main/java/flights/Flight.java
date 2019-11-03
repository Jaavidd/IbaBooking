package flights;

import java.util.Date;
import java.util.HashMap;

public class Flight {

    private int id; //TODO change to string , ex -> HE110, JB201
    private int numberOfSeats;
    private HashMap<Integer, Client> seats; //TODO max size,  different class

    private Date startingDate; //current time + 24h
    private Date destinationDate; // starting time + (flying time)

    private Cities startingCity; //TODO default Kiev, change String to enum City
    private Cities destinationCity; //TODO Random cities (create enum)

    public Flight(int id, int numberOfSeats,
                  HashMap<Integer, Client> seats,
                  Date startingDate, Date destinationDate,
                  Cities startingCity, Cities destinationPoint) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.seats = seats;
        this.startingDate = startingDate;
        this.destinationDate = destinationDate;
        this.startingCity = startingCity;
        this.destinationCity = destinationPoint;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("id=").append(id);
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", seats=").append(seats);
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

    public Cities getStartingCity() {
        return startingCity;
    }

    public Cities getDestinationCity() {
        return destinationCity;
    }
}
