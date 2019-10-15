import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyClientSocket implements Closeable {
    private Socket clientSocket;
    private BufferedReader readFromConsole;
    private BufferedReader in;
    private BufferedWriter out;

    public MyClientSocket(InetAddress address, int port) throws IOException{
        System.out.println("Client try to connect to server");
        clientSocket = new Socket(address, port);
        System.out.println("Client connect to server!!! Let's start!");
        readFromConsole = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    @Override
    public void close() throws IOException {
        clientSocket.close();
        System.out.println("Client closed");
        in.close();
        readFromConsole.close();
        System.out.println( "BufferReaders closed");
        out.close();
        System.out.println( "BufferWriter closed");
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public BufferedReader getReadFromConsole() {
        return readFromConsole;
    }

    public void setReadFromConsole(BufferedReader readFromConsole) {
        this.readFromConsole = readFromConsole;
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
