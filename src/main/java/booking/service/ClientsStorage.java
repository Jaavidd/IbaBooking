package booking.service;

import dao.Dao;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ClientsStorage implements Dao<Client> {

    private ArrayList<Client> allClients=new ArrayList<>();
    private FileWriter writer;



    public ArrayList<Client> getAll() {
        return allClients;
    }



    @Override
    public void save(Client data) {
        allClients.add(data);

    }
    public Client get(int id) {
        for(Client client: allClients){
            if(client.getUserId()==id)
                return client;
        }
        return null;
    }


    public int clientId(Client client) {
        for(Client client1: allClients){
            if(client1.equals(client))
                return client1.getUserId();
        }

        throw new NoSuchElementException("There is no client in our databases");
    }



    @Override
    public void update(Client data) {
        allClients.set(allClients.indexOf(data), data);
    }

    public void deleteById(int id){
        try {
            allClients.forEach(client -> {if (client.getUserId()==id)  allClients.remove(client);} );
        }catch (IndexOutOfBoundsException e){
            System.out.println("There is no client with this id");
        }
    }

    @Override
    public void deleteByObject(Client client) {
        try {
            allClients.forEach(client1 -> {if(client1.equals(client)); allClients.remove(client); });
        }catch (IndexOutOfBoundsException e) {
            System.out.println("No client");
        }
    }


}
