/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication140;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yunus
 */
public class udpClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = null;
            try {
                ip = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                System.out.println("IP address exception dedected!");
            }
            byte buf[] = null;
            
            while (true)
                
            {
                
                String inp = sc.nextLine();
                buf = inp.getBytes();
                DatagramPacket DpSend =
                        new DatagramPacket(buf, buf.length, ip, 1305);
                try {
                    ds.send(DpSend);
                } catch (IOException ex) {
                    System.out.println("Input/Output exception dedected!");
                }
                
                if (inp.equals("bye"))
                    break;
                
            }
        } 
        catch (SocketException ex) {
        System.out.println("Socket exception dedected!");
        }
    }
}