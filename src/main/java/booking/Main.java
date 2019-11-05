package booking;

import booking.controller.Controller;
import booking.service.Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller=new Controller();
        controller.service.service.GetAllClients();
        Client cl=new Client("Javid","Mammadli");
        controller.service.AddToDataBase(cl);
        Client cl1=new Client("Alexey","Petrov");
        controller.service.AddToDataBase(cl1);
    }
}

