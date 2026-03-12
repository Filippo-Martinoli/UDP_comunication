package comunicazionemulticastudp;

import static comunicazionemulticastudp.ServerMulticastUDP.ANSI_BLUE;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMulticastUDP {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String  RED_BOLD = "\033[1;31m";
    public static final String GREEN_UNDERLINED = "\033[4;32m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {
        int port=2000;
        int portGroup=1900;
        InetAddress serverAddress;
        DatagramSocket dSocket = null;
        MulticastSocket mSocket = null;
        InetAddress group;
        DatagramPacket outPacket;
        DatagramPacket inPacket;
        byte[] inbuffer = new byte[256];
        byte[] inbufferG = new byte[1024];
        String messageOut = "Richiesta comunivazione";
        String messageIn;