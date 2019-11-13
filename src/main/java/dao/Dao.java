package dao;

import java.io.IOException;
import java.util.ArrayList;

public interface Dao<T> {
    T get(int id) throws IOException, ClassNotFoundException;

    ArrayList<T> getAll() throws IOException, ClassNotFoundException;

    void save(T t) throws IOException, ClassNotFoundException;

    void update(T t) throws IOException, ClassNotFoundException;

    void deleteById(int id) throws IOException, ClassNotFoundException;

    void deleteByObject(T t) throws IOException, ClassNotFoundException;

}
