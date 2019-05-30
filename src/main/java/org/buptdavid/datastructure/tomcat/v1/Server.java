package org.buptdavid.datastructure.tomcat.v1;

import org.buptdavid.datastructure.tomcat.v1.util.FileUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try
        {
            serverSocket = new ServerSocket(8182);

            while (true)
            {
                try (Socket socket = serverSocket.accept();
                     InputStream is = socket.getInputStream();
                     OutputStream os = socket.getOutputStream();
                ) {
                    dealReauest(is, os);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void dealReauest(InputStream is, OutputStream os) throws Exception {
        //解析请求数据
        HttpRequst httpRequst = parseV3(is);
        String data = deal(httpRequst);
        sendData(data,os);
    }

    private static String deal(HttpRequst httpRequst) {
        String type = httpRequst.getProtocol();
        String path = httpRequst.getRequrl();
        String data = "";
        if("GET".equalsIgnoreCase(type))
        {
            data = doGet(path);
        }
        if("PSOT".equalsIgnoreCase(type))
        {
            data = doPost(path); 
        }
        return data;
    }

    private static String doPost(String path) {
        return "";
    }

    private static String doGet(String path) {
        String url = parsePath(path);
        String contentBody = FileUtil.readFileToString(url);
        return contentBody;
    }


    private static void sendData(String data, OutputStream os) throws Exception{
        os.write("HTTP/1.1 200 OK\n".getBytes());
        os.write("Content-Type:text/html;charset=utf-8\n".getBytes());
        os.write("Server:Apache-Coyote/1.1\n".getBytes());
        os.write("\n\n".getBytes());
        os.write(data.getBytes("utf-8"));
        os.flush();
    }

    /**
     * 获取请求字符数据
     * @param is
     * @throws Exception
     */
    private static HttpRequst parseV3(InputStream is)throws Exception {
        StringBuffer content = new StringBuffer(2048);
        byte[] buffer =  new byte[2048];
        int i = is.read(buffer);
        for (int j = 0; j < i; j++) {
            content.append((char)buffer[j]);
        }
        //System.out.println(content);
        HttpRequst httpRequst = new HttpRequst();
        Map<String,String> headers = new HashMap<>();
        String[] request = content.toString().split("\n");
        for (int j = 1; j < request.length; j++) {
            System.out.println(request[j]);
            if(request[j].trim().equals(""))
            {
                continue;
            }
            String[] key_value = request[j].split(":");
            headers.put(key_value[0],key_value[1]);
        }
        httpRequst.setHeaders(headers);
        if(request.length!=0)
        {
            String resource = request[0];
            String[] resources = resource.split(" ");
            String type = resources[0];
            String path = resources[1];
            String vsersion = resources[2];
            httpRequst.setProtocol(type);
            httpRequst.setRequrl(path);
        }
        return  httpRequst;

    }

    private static String parsePath(String path) {
        if("/".equalsIgnoreCase(path))
        {
            return "E:\\data\\ideaspace\\datastructure\\src\\main\\java\\org\\buptdavid\\datastructure\\tomcat\\v1\\index.html";
        }
        return "";
    }

    /**
     * 无法获取到请求字符数据
     * @param is
     * @throws Exception
     */
    private static void parseV2(InputStream is)throws Exception {
        StringBuffer content = new StringBuffer(2048);
        byte[] buffer =  new byte[2048];
        is.read(buffer);
        content.append(buffer);
        System.out.println(content);
    }

    /**
     * V1 会阻塞
     * @param is
     * @throws Exception
     */
    private static void parse(InputStream is)throws Exception {
            int i = is.read();
            while (i!=-1)
            {
                System.out.print((char)i);
                i = is.read();
            }
    }
}
