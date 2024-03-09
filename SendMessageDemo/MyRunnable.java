package SendMessageDemo;

import java.io.*;
import java.net.Socket;

public class MyRunnable implements Runnable{
    Socket socket;

    public MyRunnable(Socket socket){
       this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(""));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            byte[] bytes = new byte[1024];
            int len;
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            bos.close();
            socket.shutdownOutput();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println(line);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
