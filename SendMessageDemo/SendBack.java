package SendMessageDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendBack {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10086);

        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        int b;
        while ((b = isr.read()) != -1){
            System.out.println((char) b);
        }

        String str = "到底有多开心？";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        socket.close();
        ss.close();
    }
}
