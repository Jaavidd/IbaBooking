package storage;

import controller.FlightsController;
import flights.Flight;

import java.io.*;
import java.util.ArrayList;

public class DataFlight {


    private String path = "storage/base.bin";
    private File base = new File(path);


    public DataFlight(String path, FlightsController controller) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(controller.getAllFlight());
            oos.close();
            fos.close();
            System.out.println("ok");
        } catch (IOException ex) {
            System.out.println("save ex");
        }
    }

    public ArrayList<Flight> loadFlight(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Flight> flights = (ArrayList<Flight>) ois.readObject();
        ois.close();
        fis.close();
        return flights;
    }
}