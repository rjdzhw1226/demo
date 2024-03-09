package SendMessageDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receivefile {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(10086);
            while(true){
                Socket socket = s.accept();
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(""));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = bis.read(bytes)) != -1){
                    bos.write(bytes,0,len);
                    bos.flush();
                }
                bos.close();

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("上传成功");
                bw.newLine();
                bw.flush();

                socket.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
