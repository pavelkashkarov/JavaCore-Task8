import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8080;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                out.println("Write your name");
                String name = in.readLine();

                out.println("Are you child? (yes/no)");
                String answer = in.readLine();

                out.println(resultAnswer(answer, name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String resultAnswer(String answer, String name) {
        if (answer.equals("yes")) {
            return "Welcome to the kids area, " + name + "! Let's play!";
        }
        else
        {
            return "Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!";
        }
    }
}