package booking.service;

import booking.DAO.Dao;

import java.io.File;
import java.io.IOException;

public class Service {

    public Dao<Client> service= new ClientsStorage();
    private File file=new File("./clientsData.txt");


    public boolean cancelBooking(Client client,int FlightId) {

        try {
            client.getMyFlights().forEach(flight ->{ if(flight.getId()==FlightId); client.cancelFlight(flight);} );
            return true;
        }catch (IndexOutOfBoundsException e) {
            return false;
        }

    }
    public void addToDataBase(Client client) throws IOException {
//        FileWriter writer=new FileWriter(file);
//        writer.write("\n");
//        writer.write(client.toString());
//        writer.close();
    }

    public void myFlights(String name,String surname){
        for(Client client: service.getAll()) {
            if (client.getName().equals(name) && client.getSurname().equals(surname)) {
                System.out.print("Your flights: ");
                System.out.print(client.getMyFlights());

            }
        }

    }
}
