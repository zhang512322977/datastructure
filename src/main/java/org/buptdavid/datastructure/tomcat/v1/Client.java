package org.buptdavid.datastructure.tomcat.v1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("www.baidu.com",80);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
        )
        {
            os.write("GET / HTTP/1.1\n".getBytes());
            os.write("HOST: www.baidu.com\n".getBytes());
            os.write("\n".getBytes());
            int i = is.read();
            while (i!=-1)
            {
                System.out.print((char)i);
                i = is.read();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }



}
