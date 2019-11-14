
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
    private DataFlight df = new DataFlight();
    private ArrayList<Flight> flights;

    public Console() throws ParseException, IOException, ClassNotFoundException {
        Random random = new Random();
        if (df.loadFlight() == null) {
            for (int x = 0; x < random.nextInt(20) + 20; x++)
                fc.createRandomFlight();
            df = new DataFlight(fc);
        } else {
            flights = df.loadFlight();
            for (Flight flight : flights) {
                fc.addFlight(flight);
            }
            df = new DataFlight(fc);
        }
    }

    public void printer(String message) {
        System.out.print(message);
    }

    public void searchAndBook() throws IOException, ClassNotFoundException, ParseException {
        String city, data;
        long date;
        int people, userSelection;

        printer("Please enter destination city : ");
        city = scan.next();
        printer("Please enter date : ");
        data = "";
        data += scan.nextLine();
        data += scan.nextLine();
        date = converter.DateConverter.stringToMills(data);
        printer("Please how many people will travel : ");
        people = scan.nextInt();
        ArrayList<Flight> cFlight = fc.getAvailableFlight(city, people, new Date(date));
        System.out.println("\nMost similar results :");
        printer(cFlight.toString() + "\n");
        printer("Select any available flights above : ");
        userSelection = scan.nextInt();
        if (!cFlight.contains(userSelection) || userSelection < 0) {
            System.out.println("Wrong Selection");
            return;
        } else if (userSelection == 0)
            return;
        else {
            for (int a = 0; a < people; a++) {
                printer("Enter name of passenger : \n");
                String name = scan.next();
                printer("Enter surname of passenger : \n");
                String surname = scan.next();
                fc.addClient(userSelection, new Client(name, surname));
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
        int counter = 1;

        for (Flight item : fc.getAllFlight()) {
            for (HashMap.Entry<Integer, Client> entry : item.getSeats().entrySet()) {
                if (entry.getValue().getUserId() == id) {
                    printer("\nAll available flights :\n");
                    for (Flight flight : entry.getValue().getMyFlights())
                        printer(counter + ") " + flight.toString() + "\n");

                    printer("Please enter flight number :");
                    int newID = scan.nextInt();
                    boolean succes = false;

                    for (Flight flight : entry.getValue().getMyFlights()) {
                        if (flight.getId() == newID) {
                            printer("\nOperation successful flight canceled\n");
                            entry.getValue().cancelFlight(flight);
                            succes = true;
                        }
                    }

                    if (!succes)
                        printer("\nFlight cancellation is unsuccessful you do not have this flight ");
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
        else if (command.equals("exit") || command.equals("6")) {
            df = new DataFlight(fc);
            System.exit(0);
        }
    }


}
