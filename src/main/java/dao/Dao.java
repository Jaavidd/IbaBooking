package dao;

import flights.Flight;

import java.util.ArrayList;

public interface Dao<T> {
    Flight get(int id);

    ArrayList<T> getAll();

    void save(T t);

    void update(T t);

    void deleteById(int id);

    void deleteByObject(T t);
}
