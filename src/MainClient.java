public class MainClient {

    public static void main(String[] args) {

        try {

            ClientUDP client = new ClientUDP("localhost", 4000);
            client.sendMessages();
            client.close();
        } catch(Exception e) {
            System.out.println("Errore avvio client!");
        }
    }
}