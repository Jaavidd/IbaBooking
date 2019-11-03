package booking;

import booking.controller.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller=new Controller();
        controller.service.service.GetAllClients();
        File f=new File("./out.txt");
        FileWriter fw=new FileWriter(f);
        String str="id 2: Kiev  Los-Angeles 10/11/2019";
          fw.write("javid");
        fw.close();
        if(f.length()==0)
            System.out.println("emp");
//
        List<Integer> l=new ArrayList<>();
//        Collections.sort (l

    }
}

