package storage;

import controller.FlightsController;
import flights.Flight;

import java.io.*;
import java.util.ArrayList;

public class DataFlight {

    private String path = "base.bin";



    public DataFlight(FlightsController controller) throws IOException, ClassNotFoundException {
        File base = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(base);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(controller.getAllFlight());
            oos.close();
            fos.close();
            System.out.println("Save done");
        } catch (IOException ex) {
            System.out.println("save ex");
        }
    }

    public DataFlight() {
    }

    public ArrayList<Flight> loadFlight() throws IOException, ClassNotFoundException {
        File base = new File(path);
        FileInputStream fis = new FileInputStream(base);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Flight> flights = (ArrayList<Flight>) ois.readObject();
        ois.close();
        fis.close();
        return flights;
    }
}