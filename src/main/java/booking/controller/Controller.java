package booking.controller;

import booking.service.Client;
import booking.service.Service;

import java.io.IOException;

public class Controller {

  public Service service = new Service();


  public void AddToData(Client c) throws IOException {
  }


  public boolean CancelBooking(Client client, int FlightId) {
    return service.CancelBooking(client, FlightId);
  }


  public void AddToDataBase(Client client) throws IOException {
    service.AddToDataBase(client);
  }

  public void myFlights(String name, String surname) {
    service.myFlights(name,surname);
  }
}