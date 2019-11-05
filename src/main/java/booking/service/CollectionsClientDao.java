package booking.service;

import booking.DAO.DaoInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CollectionsClientDao implements DaoInterface<Client> {

    private List<Client> AllClients=new ArrayList<>();
    private   FileWriter writer;



    public List<Client> GetAllClients() {
        return AllClients;
    }
    @Override
    public void store(Client data) {
        AllClients.add(data);

    }
    public void AddToDataBase(Client client) throws IOException {
        final  File file=new File("./clients_data.txt");
        final  FileWriter writer=new FileWriter(file);
        if(file.exists())
            writer.write("\n");
            writer.append(client.toString());
            writer.close();
    }

    @Override
    public int clientId(Client client) {
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
