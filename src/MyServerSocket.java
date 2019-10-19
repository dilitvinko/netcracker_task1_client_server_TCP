import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;
import java.util.StringTokenizer;

public class MyServerSocket implements Closeable {

    private ServerSocket server;
    private Socket clientSocket; //сокет для общения
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    MyServerSocket(int port) throws IOException {

        server = new ServerSocket(port);
        System.out.println("Server Started!");
    }

    private static String invert(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            stack.push(st.nextToken());
        }
        while (!stack.empty()) {
            res.append(stack.pop()).append(" ");
        }
        return res.toString();
    }

    void myAccept() throws IOException {
        clientSocket = server.accept();
        System.out.println("Client connect to Server");
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    void readInvertReceiveText() throws IOException {
        String text = in.readLine();
        out.write(invert(text) + "\n");
        out.flush();
    }

    @Override
    public void close() throws IOException {
        clientSocket.close();
        System.out.println("client closed");
        server.close();
        System.out.println("server closed");
        in.close();
        System.out.println("BufferReader closed");
        out.close();
        System.out.println("BufferWriter closed");

    }

}
