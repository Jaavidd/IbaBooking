package booking.DAO;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void deleteById(int id);

    void deleteByObject(T t);
}
