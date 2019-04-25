/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 *
 * @author tommib
 */
public class StreamGamePlay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        List<Computer> computers = new ArrayList<>();
        computers.add(new Computer(1, "Seeker"));
        computers.add(new Computer(2, "Destroyer"));
        computers.add(new Computer(3, "backup"));
        computers.add(new Computer(4, "Seeker"));

        System.out.println("Stream simple collect");
        Compute copyComputers = () -> computers.stream().collect(Collectors.toCollection(ArrayList::new));
        List<Computer> computers2 = copyComputers.modifiedList();
        computers2.forEach(s -> System.out.println(s));

        System.out.println("Stream filter primitive datatype");
        Compute filterByID = () -> computers.stream().filter(s -> s.getId() % 2 == 0).collect(Collectors.toCollection(ArrayList::new));
        List<Computer> computers3 = filterByID.modifiedList();
        computers3.forEach(s -> System.out.println(s));

        System.out.println("Stream filter object");
        Compute filterByName = () -> computers.stream().filter(s -> s.getName().equals("Destroyer")).collect(Collectors.toCollection(ArrayList::new));
        List<Computer> computers4 = filterByName.modifiedList();
        computers4.stream().forEach(s -> System.out.println(s));
        
        System.out.println("Stream map");
        Compute changeIds = () -> computers.stream().map(s -> new Computer(new Random().nextInt(50), s.getName())).collect(Collectors.toCollection(ArrayList::new));
        List<Computer> computers5 = changeIds.modifiedList();
        computers5.forEach(s -> System.out.println(s));
        
    }

}
