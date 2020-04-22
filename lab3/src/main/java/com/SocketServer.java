package com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {
    public static final int PORT_NUMBER = 8083;

    public Socket socket;

    private SocketServer(Socket socket) {
        this.socket = socket;
        System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
        start();
    }

    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String incomeMessage;
            while ((incomeMessage = br.readLine()) != null) {
                System.out.println("Message received:" + incomeMessage);
                incomeMessage = incomeMessage.replaceAll("\\[", "(").replaceAll("\\]",")")
                        .replaceAll("\\{", "(").replaceAll("\\}", ")");
                incomeMessage += '\n';
                out.write(incomeMessage.getBytes());
            }

        } catch (IOException ex) {
            System.out.println("Unable to get streams from client");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT_NUMBER);
            System.out.println("SocketServer started!");
            while (true) {
                /**
                 * create a new {@link SocketServer} object for each connection
                 * this will allow multiple client connections
                 */
                new SocketServer(server.accept());
            }
        } catch (IOException ex) {
            System.out.println("Unable to start server.");
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}