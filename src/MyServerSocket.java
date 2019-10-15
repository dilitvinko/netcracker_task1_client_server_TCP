import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket implements Closeable {

    private ServerSocket server; // серверсокет
    private Socket clientSocket; //сокет для общения
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    public MyServerSocket(int port) throws IOException{

        server = new ServerSocket(port);
        System.out.println("Server Started!");
        clientSocket = server.accept();
        System.out.println("Client connect to Server");
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));



    }

    @Override
    public void close() throws IOException {
        clientSocket.close();
        System.out.println( "client closed");
        server.close();
        System.out.println( "server closed");
        in.close();
        System.out.println( "BufferReader closed");
        out.close();
        System.out.println( "BufferWriter closed");

    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public void setOut(BufferedWriter out) {
        this.out = out;
    }
}
