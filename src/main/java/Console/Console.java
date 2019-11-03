package Console;

import Controller.Controller;
import java.util.Scanner;

public class Console {

    Controller _controller_;
    Scanner console_scanner;



    public void console_printer(String data){
        System.out.println(data);
    }




    public void main_menu(){
        console_printer("___________ Main Menu ___________");
        System.out.println("Select one of the option listed below : ");
        System.out.println("1) Show the flight Info ");
        System.out.println("2) Search and Book Flight");
        System.out.println("3) Cancel bookings");
        System.out.println("4) My Flights");
        int option=console_scanner.nextInt();

        if(option==1){
           _controller_.getInfo24();
        }

    }




    public Console(){
     _controller_=new Controller();
     console_scanner=new Scanner(System.in);
     console_printer("******** All flights from Kiev for next 24 hours **********");
     console_printer(_controller_.getInfo24());

     //continuous work here

    }



}
