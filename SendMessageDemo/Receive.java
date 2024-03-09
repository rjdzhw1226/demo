package SendMessageDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receive {

    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        while (true){
            ds.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();
            InetAddress address = dp.getAddress();
            int port = dp.getPort();

            System.out.println("接收到数据" + new String(data,0,len) + "来自" + address + "电脑" + port + "端口");
        }

    }

}
