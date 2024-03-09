package SendMessageDemo;

import java.io.*;
import java.net.Socket;

public class Sendfile {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",10086);
            Thread thread = new Thread(new MyRunnable(socket));
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
