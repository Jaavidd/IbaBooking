package booking.service;

import booking.DAO.DaoInterface;

public class Service {

   public DaoInterface<Client> service= new CollectionsClientDao();

    public boolean CancelBooking(Client client,int FlightId) {
//        for(Client client1: service.GetAllClients()){
//            if(client1.equals(client)){
//                client1.getMyFlights().contains(Fligt.getId(FlightId))
//            throw new IllegalArgumentException(" TODO");
//            }
//        }
        try {
            service.GetAllClients().forEach(c -> {
                if (c.equals(client)) c.getMyFlights().remove(3) ;});
                return true;
        }catch (IndexOutOfBoundsException e) {
            return false;
        }

    }
}
