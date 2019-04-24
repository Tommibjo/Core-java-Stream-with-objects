/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpalvelinmooc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author tommib
 */
public class WebPalvelinMooc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String osoite = "www.google.com";
        int portti = 80;
        
        Socket socket = new Socket(osoite,portti);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("GET / HTTP/1.1");
        printWriter.println("Host: " + osoite);
        printWriter.println();
        printWriter.flush();
        
        Scanner lukija = new Scanner(socket.getInputStream());
        Stream.of(lukija).forEach(s -> System.out.println(s.nextLine()));
    }
    
}
