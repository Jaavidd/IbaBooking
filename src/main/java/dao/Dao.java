package dao;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id);
    Collection<T> getAll();
    void save(T t);
    void update(T t);
    void deleteById(int id);
    void deleteByObject(T t);
}
