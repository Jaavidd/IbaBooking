package storage;

import dao.Dao;
import flights.Flight;

import java.io.*;
import java.util.ArrayList;

public class DataFlight implements Dao<Flight> {

    private File base = new File("storage/base.bin");

    private FileOutputStream fileOutputStream = new FileOutputStream(base);
    private ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    FileInputStream fileInputStream= new FileInputStream(base);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    public DataFlight() throws IOException {

    }

    @Override
    public Flight get(int id) throws IOException, ClassNotFoundException {
        ArrayList<Flight> flightList = (ArrayList<Flight>) objectInputStream.readObject();
        return flightList.get(id);
    }

    @Override
    public ArrayList<Flight> getAll() throws IOException, ClassNotFoundException {
        return (ArrayList<Flight>) objectInputStream.readObject();
    }

    @Override
    public void save(Flight flight) throws IOException, ClassNotFoundException {
        ArrayList<Flight> flightList = (ArrayList<Flight>) objectInputStream.readObject();
        flightList.add(flight);
        objectOutputStream.writeObject(flightList);
        objectOutputStream.close();
    }

    @Override
    public void update(Flight flight) throws IOException, ClassNotFoundException {
        ArrayList<Flight> flightList = (ArrayList<Flight>) objectInputStream.readObject();
        flightList.set(flightList.indexOf(flight), flight);
        objectOutputStream.writeObject(flightList);
        objectOutputStream.close();
    }

    @Override
    public void deleteById(int id) throws IOException, ClassNotFoundException {
        ArrayList<Flight> flightList = (ArrayList<Flight>) objectInputStream.readObject();
        flightList.remove(id);
        objectOutputStream.writeObject(flightList);
        objectOutputStream.close();
    }

    @Override
    public void deleteByObject(Flight flight) throws IOException, ClassNotFoundException {
        ArrayList<Flight> flightList = (ArrayList<Flight>) objectInputStream.readObject();
        flightList.remove(flight);
        objectOutputStream.writeObject(flightList);
        objectOutputStream.close();
    }
}
