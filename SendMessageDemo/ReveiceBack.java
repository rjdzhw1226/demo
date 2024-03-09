package SendMessageDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ReveiceBack {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",10086);

        String str = "见到你很高兴！";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        int b;
        while ((b = isr.read()) != -1){
            System.out.println((char) b);
        }
        socket.close();
    }
}
