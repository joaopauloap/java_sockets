package org.example.client;

import java.io.*;
import java.net.*;

public class ClientCLI {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String messageToSend;

            while (true) {
                System.out.print("Digite uma mensagem para enviar ao servidor: ");
                messageToSend = reader.readLine();

                out.println(messageToSend);

                String response = in.readLine();
                System.out.println("Servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
