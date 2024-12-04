import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void start() throws IOException {
        socket = new Socket("localhost", 12345);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void sendRequest(Object request) throws IOException {
        out.writeObject(request);
    }

    public Object receiveResponse() throws IOException, ClassNotFoundException {
        return in.readObject();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.start();
            
            // Ejemplo: enviar un paciente y recibir la confirmación
            Patient patient = new Patient("Juan Perez", 35, "Sin alergias");
            client.sendRequest(patient);
            String response = (String) client.receiveResponse();
            System.out.println("Respuesta del servidor: " + response);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
