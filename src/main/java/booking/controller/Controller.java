package booking.controller;

import booking.service.Client;
import booking.service.Service;

import java.io.IOException;

public class Controller {

  public   Service service=new Service();
    int a;

  public void AddToData(Client c) throws IOException {
    service.AddToDataBase(c);
  }

}
