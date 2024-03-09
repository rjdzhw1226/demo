package SendMessageDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendNewMeter {

    public static void main(String[] args) throws IOException {

        //创建Socket对象
        //创建同时会连接服务端
        Socket socket = new Socket("127.0.0.1",10086);

        //可以从连接中获取输出流
        OutputStream os = socket.getOutputStream();
        os.write("你好你好".getBytes());

        os.close();
        socket.close();
    }

}
