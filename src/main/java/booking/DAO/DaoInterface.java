package booking.DAO;

import booking.service.Client;

import java.io.IOException;
import java.util.List;

public interface DaoInterface<T> {
    void store(T data);

    int clientId(Client client);

    void delete(int id);

    void update(T data);

    List<T> GetAllClients();

    void AddToDataBase(Client client) throws IOException;

}