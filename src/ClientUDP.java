import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientUDP {

    private DatagramSocket dSocket;
    private InetAddress serverAddress;
    private int port;

    public ClientUDP(String host, int port) throws UnknownHostException, SocketException {

        this.port = port;
        dSocket = new DatagramSocket();
        serverAddress = InetAddress.getByName(host);
        System.out.println("Client avviato");
        System.out.println("Indirizzo server: " + serverAddress);
        System.out.println("Porta server: " + port);
    }

    public void sendMessages() {

        Scanner input = new Scanner(System.in);

        try {

            while(true) {

                System.out.print("Inserisci messaggio da inviare (exit per uscire): ");
                String message = input.nextLine();

                if(message.equalsIgnoreCase("exit")) {
                    System.out.println("Chiusura client...");
                    break;
                }

                byte[] bufferOut = message.getBytes();
                DatagramPacket outPacket =
                        new DatagramPacket(bufferOut, bufferOut.length, serverAddress, port);
                System.out.println("Invio messaggio al server...");
                dSocket.send(outPacket);
                byte[] bufferIn = new byte[256];
                DatagramPacket inPacket = new DatagramPacket(bufferIn, bufferIn.length);
                dSocket.receive(inPacket);
                String response = new String(inPacket.getData(), 0, inPacket.getLength());

                System.out.println("Risposta ricevuta dal server: " + response);
            }

        } catch(IOException e) {
            System.err.println("Errore di comunicazione!");
        }

    }

    public void close() {
        dSocket.close();
        System.out.println("Socket chiuso.");
    }
}