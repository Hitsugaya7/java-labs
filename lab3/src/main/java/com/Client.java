package com;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static final String FILE_NAME = "output";

    public static void main(String args[]) {
        int port = 8081;
        new Client(port);
    }

    public Client(int port) {
        try {
            String serverHostname = "127.0.0.1";

            System.out.println("Connecting to host " + serverHostname + " on port " + port + ".");

            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket(serverHostname, 8081);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + serverHostname);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Unable to get streams from server");
                System.exit(1);
            }

            /** {@link UnknownHost} object used to read from console */
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Write q for exit");
            while (true) {
                System.out.print("Write message for sending to server: ");
                String ClientMessage = stdIn.readLine();
                /** Exit on 'q' char sent */
                if ("q".equals(ClientMessage)) {
                    break;
                }
                out.println(ClientMessage);
                String ServerMessage = in.readLine();
                System.out.println("Message from server: " + ServerMessage);
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
                writer.write("Message from client: " + ClientMessage + "\n");
                writer.write("Answer from server: " +  ServerMessage + "\n");

                writer.close();
            }

            /** Closing all the resources */
            out.close();
            in.close();
            stdIn.close();
            echoSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}