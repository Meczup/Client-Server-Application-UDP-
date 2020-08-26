/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication140;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 *
 * @author yunus
 */
public class udpServer {
 public static void main(String[] args) 

    {

        DatagramSocket ds = null;
     try {
         ds = new DatagramSocket(1305);
     } catch (SocketException ex) {
         System.out.println("Socket exception dedected!");
     }
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;

        while (true)
        {
            DpReceive = new DatagramPacket(receive, receive.length);
            try {
                ds.receive(DpReceive);
            } catch (IOException ex) {
                System.out.println("IO exception dedected!");
            }
            System.out.println("Client:-" + data(receive));

            if (data(receive).toString().trim().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }

          receive = new byte[65535];
        }
    }

  public static StringBuilder data(byte[] a)

    {
        if (a == null)
            return null;

        StringBuilder ret = new StringBuilder();
        int i = 0;
        
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }

}