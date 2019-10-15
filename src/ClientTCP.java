import java.io.*;
import java.net.InetAddress;

public class ClientTCP {
    public static void main(String[] args) {
        try ( MyClientSocket myClientSocket = new MyClientSocket(InetAddress.getLocalHost(), 8040)
        ) {
            System.out.println("Please, write you text: ");

            String text = myClientSocket.getReadFromConsole().readLine();

            myClientSocket.getOut().write(text + "\n");
            myClientSocket.getOut().flush();

            String textFromServer = myClientSocket.getIn().readLine();
            System.out.println("Text from server: " + textFromServer);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
