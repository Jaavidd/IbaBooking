package booking.controller;

import booking.service.Client;
import booking.service.Service;

import java.io.IOException;

public class Controller {

  public Service service = new Service();



  public boolean cancelBooking(Client client, int FlightId) {
    return service.cancelBooking(client, FlightId);
  }


  public void addToDataBase(Client client) throws IOException {
    service.addToDataBase(client);
  }

  public void myFlights(String name, String surname) throws IOException, ClassNotFoundException {
    service.myFlights(name,surname);
  }
}