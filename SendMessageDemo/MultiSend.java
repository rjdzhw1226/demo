package SendMessageDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiSend {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",10086);

        Scanner sc = new Scanner(System.in);

        OutputStream os = socket.getOutputStream();

        while (true){
            System.out.println("请输入要发送的信息");
            String str = sc.nextLine();
            if("结束通信".equals(str)){
                break;
            }
            os.write(str.getBytes());
        }

        socket.close();
    }
}
