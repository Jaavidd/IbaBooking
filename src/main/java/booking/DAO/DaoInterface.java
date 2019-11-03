package booking.DAO;

import booking.service.Client;

import java.util.List;

public interface DaoInterface<T> {
    void store(T data);

    int GetId(Client client);

    void delete(int id);

    void update(T data);

    List<T> GetAllClients();

}
