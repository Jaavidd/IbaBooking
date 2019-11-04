package booking.DAO;

import booking.service.Client;

import java.util.List;

public interface DaoInterface<T> { //we will change this to another Dao interface
    void store(T data);

    int GetId(Client client); //change to get(int clientId)

    void delete(int id);

    void update(T data);

    List<T> GetAllClients();

}
