package flights;

import dao.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageFlights implements Dao<Flight> {

    List<Flight> flightList = new ArrayList<>();


    @Override
    public Optional<Flight> get(int id) {
        if(get(id).isPresent()){
            return Optional.of(flightList.get(id));
        }else return Optional.empty();
    }

    @Override
    public List<Flight> getAll() {
        return flightList;
    }

    @Override
    public void save(Flight flight) {
        flightList.add(flight);
    }

    @Override
    public void update(Flight flight) {
        flightList.set(flightList.indexOf(flight), flight);
    }

    @Override
    public void deleteById(int id) {
        flightList.remove(id);
    }

    @Override
    public void deleteByObject(Flight flight) {
        flightList.remove(flight);
    }
}
