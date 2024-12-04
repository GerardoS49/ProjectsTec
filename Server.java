import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(12345);
        System.out.println("Servidor iniciado...");
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void run() {
        try {
            Object request = in.readObject();
            // Procesar la solicitud del cliente (p.ej., agregar paciente)
            if (request instanceof Patient) {
                Patient patient = (Patient) request;
                System.out.println("Recibido paciente: " + patient.getName());
                out.writeObject("Paciente registrado exitosamente");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
