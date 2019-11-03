package booking.service;

import booking.DAO.DaoInterface;

public class Service {

    DaoInterface<Client> service= new CollectionsClientDao();

    public boolean CancelBooking(Client client,int FlightId) {
        for(Client client1: service.GetAllClients()){
            if(client1.equals(client)){
//                client1.getMyFlights().contains(Fligt.getId(FlightId))
            throw new IllegalArgumentException(" TODO");
            }
        }

    return false;

    }
}
