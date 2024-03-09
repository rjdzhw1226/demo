package SendMessageDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveNewMeter {

    public static void main(String[] args) throws IOException {

        //创建对象ServerSocker
        ServerSocket ss = new ServerSocket(10086);
        //监听客户端的连接
        Socket socket = ss.accept();

        //从连接通道中获取输入流数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);//为了解决乱码用字符流杜

        int b;

        while ((b = isr.read()) != -1){
            System.out.println((char) b);
        }

        socket.close();
        ss.close();

    }

}
