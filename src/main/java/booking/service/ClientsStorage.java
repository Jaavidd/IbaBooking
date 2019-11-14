package booking.service;

import booking.DAO.Dao;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ClientsStorage implements Dao<Client> {

    private List<Client> AllClients=new ArrayList<>();
    private   FileWriter writer;



    public List<Client> getAll() {
        return AllClients;
    }



    @Override
    public void save(Client data) {
        AllClients.add(data);

    }
    public Client get(int id) {
        for(Client client: AllClients){
            if(client.getUserId()==id)
                return client;
        }
        return null;
    }


    public int clientId(Client client) {
        for(Client client1: AllClients){
            if(client1.equals(client))
                return client1.getUserId();
        }

        throw new NoSuchElementException("There is no client in our databases");
    }



    @Override
    public void update(Client data) {
        AllClients.set(AllClients.indexOf(data), data);
    }

    public void deleteById(int id){
        try {
            AllClients.forEach(client -> {if (client.getUserId()==id)  AllClients.remove(client); } );
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no client with this id");
        }
    }

    @Override
    public void deleteByObject(Client client) {
        try {
            AllClients.forEach(client1 -> {if(client1.equals(client)); AllClients.remove(client); });
        }catch (IndexOutOfBoundsException e) {
            System.out.println("No client");
        }
    }


}
