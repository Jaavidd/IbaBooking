package booking.service;

import booking.DAO.DaoInterface;

import java.util.List;
import java.util.NoSuchElementException;

public class CollectionsClientDao implements DaoInterface<Client> {


    private List<Client> AllClients;

    public List<Client> GetAllClients() {
        return AllClients;
    }
    @Override
    public void store(Client data) {
        AllClients.add(data);

    }

    @Override
    public int GetId(Client client) {
        for(Client client1: AllClients){
            if(client1.equals(client))
                return client1.getUserId();
        }

        throw new NoSuchElementException("There is no client in our databases");
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(Client data) {

    }
}
