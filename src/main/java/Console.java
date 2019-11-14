
import booking.service.Client;
import controller.FlightsController;
import flights.Flight;
import storage.DataFlight;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Console {

    private FlightsController fc = new FlightsController();
    private Scanner scan = new Scanner(System.in);

    DataFlight df;

    public Console() throws ParseException, IOException, ClassNotFoundException {
        if (fc.getAllFlight().size() == 0) { // trying to check db
            Random random = new Random();
            for (int x = 0; x < random.nextInt(20) + 20; x++)
                fc.createRandomFlight();
            df = new DataFlight(fc);}

    }

    public void printer(String message) {
        System.out.print(message);
    }

    public void searchAndBook() throws IOException, ClassNotFoundException, ParseException {
        printer("Please enter destination city : ");
        String city = scan.next();
        printer("Please enter date : ");
        String data = "";
        data += scan.nextLine();
        data += scan.nextLine();
        long date = converter.DateConverter.stringToMills(data);
        printer("Please how many people will travel : ");
        int people = scan.nextInt();
        ArrayList<Flight> cFlight = fc.getAvailableFlight(city, people, new Date(date));
        System.out.println("\nMost similar results :");
        printer(cFlight.toString() + "\n");
        printer("Select any available flights above : ");
        int selection = scan.nextInt();

        if (!cFlight.contains(selection) || selection < 0) {
            System.out.println("Wrong Selection");
            return;
        } else if (selection == 0)
            return;
        else {
            for (int a = 0; a < people; a++) {
                printer("Enter name of passenger : \n");
                String name = scan.next();
                printer("Enter surname of passenger : \n");
                String surname = scan.next();
                fc.addClient(selection, new Client(name, surname));
            }
        }
    }

    public void showFlightInfo() throws IOException, ClassNotFoundException {
        printer("Please enter flight id : ");
        int query = scan.nextInt();
        printer(fc.getInfoAboutFlight(query).toString());
    }

    public void showFlights() throws IOException, ClassNotFoundException {
        printer("All available flights and their info :\n ");
        fc.getAllFlight().forEach(item -> System.out.println(item.toString()));
    }

    public void cancelBooking() throws IOException, ClassNotFoundException {

        printer("Please enter booking id :");
        int id = scan.nextInt();

        for (Flight item : fc.getAllFlight()) {
            for (HashMap.Entry<Integer, Client> entry : item.getSeats().entrySet()) {
                if (entry.getValue().getUserId() == id) {
                    printer("\nAll available flights :\n");
                    int counter = 1;
                    for (Flight flight : entry.getValue().getMyFlights())
                        printer(counter + ") " + flight.toString() + "\n");

                    printer("Please enter flight number :");
                    int flightNumber = scan.nextInt();
                    for (Flight flight : entry.getValue().getMyFlights()) {
                        if (counter == 0)
                            entry.getValue().cancelFlight(flight);
                        counter--;
                    }
                }
            }
        }

    }


    public void myFlight() throws IOException, ClassNotFoundException {
        printer("Enter name of passenger : \n");
        String name = scan.next();
        printer("Enter surname of passenger : \n");
        String surname = scan.next();
        for (Flight f : fc.getAllFlight()) {
            for (Client c : f.getSeats().values()) {
                if (c.getName().equals(name) && c.getSurname().equals(surname))
                    c.getMyFlights().forEach(item -> printer(item.toString()));
            }
        }
    }


    public void mainMenu() throws IOException, ClassNotFoundException, ParseException {

        printer("\nMainMenu: \n" +
                "Please enter one of the following command or use just number :\n" +
                "1) Display All Flights\n" +
                "2) Show FLight Info\n" +
                "3) Search and Book flight\n" +
                "4) Cancel Booking\n" +
                "5) My Flights\n" +
                "6) Exit\n" +
                "\n>>>");

        String command = scan.next().toLowerCase().replace(" ", "");
        if (command.equals("displayallflights") || command.equals("1"))
            showFlights();
        else if (command.equals("showflightinfo") || command.equals("2"))
            showFlightInfo();
        else if (command.equals("searchandbookflight") || command.equals("3"))
            searchAndBook();
        else if (command.equals("cancelbooking") || command.equals("4"))
            cancelBooking();
        else if (command.equals("myflights") || command.equals("5"))
            myFlight();
        else if (command.equals("exit") || command.equals("6")){
            df = new DataFlight(fc); // saving before exit
            System.exit(0);
        }
    }


}
