package SendMessageDemo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Send {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        //String str = "Hello World";

        while (true){

            System.out.println("请输入 stop 停止");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            if (str.equals("stop")) {
                break;
            }
            byte[] bytes = str.getBytes();

            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 10086;

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
            ds.send(dp);

        }

        ds.close();
    }
}
