import java.io.IOException;

public class ServerTCP {
    public static void main(String[] args) {

        try (MyServerSocket myServerSocket = new MyServerSocket(8040)) {
            while (true) {
                myServerSocket.myAccept();
                myServerSocket.readInvertReceiveText();
                System.out.println("Server completed some operation");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
