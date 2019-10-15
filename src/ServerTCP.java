import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class ServerTCP {
    public static void main(String[] args) {

        try (MyServerSocket myServerSocket = new MyServerSocket(8040)) {
            String text = myServerSocket.getIn().readLine();
            myServerSocket.getOut().write(invert(text) + "\n");
            myServerSocket.getOut().flush();
            System.out.println("Server completed some operation");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String invert(String str){
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            stack.push(st.nextToken());
        }
        while (!stack.empty()) {
            res.append(stack.pop() + " ");
        }
        return res.toString();
    }

}
