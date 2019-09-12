package org.buptdavid.datastructure.tomcat.v1;

import org.buptdavid.datastructure.log.Logger;
import org.buptdavid.datastructure.springmvc.DispatcherServlet;
import org.buptdavid.datastructure.tomcat.v1.util.FileUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ServletContextImpl sc = new ServletContextImpl();
        sc.init();
        try
        {
            serverSocket = new ServerSocket(8182);

            while (true)
            {
                try (Socket socket = serverSocket.accept();
                     InputStream is = socket.getInputStream();
                     OutputStream os = socket.getOutputStream();
                )
                {
                    dealReauest(is, os,sc);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    private static void dealReauest(InputStream is, OutputStream os, ServletContextImpl servletContext) throws Exception {
        //解析请求数据
        HttpServletRequest request = parseV3(is);
        //构造响应字段
        HttpServletResponse response = new HttpServletResponseImpl(new ServletOutputStreamImpl(os));

        HttpServlet servlet = servletContext.getServlet(request.getServletPath());

        servlet.service(request,response);

    }

    private static String doGet(String path) {
        String url = parsePath(path);
        String contentBody = FileUtil.readFileToString(url);
        return contentBody;
    }



    /**
     * 获取请求字符数据
     * @param is
     * @throws Exception
     */
    private static HttpServletRequest parseV3(InputStream is)throws Exception {
        StringBuffer content = new StringBuffer(2048);
        byte[] buffer =  new byte[2048];
        int i = is.read(buffer);
        for (int j = 0; j < i; j++) {
            content.append((char)buffer[j]);
        }
        HttpServletRequstImpl httpRequst = new HttpServletRequstImpl();
        Map<String,String> headers = new HashMap<>();
        String[] request = content.toString().split("\n");

        int bodyIndex = -1;
        for (int j = 1; j < request.length; j++) {
            System.out.println(request[j]);

            if(request[j].equals("\r"))
            {
                bodyIndex = j;
                break;
            }

            if(request[j].trim().equals(""))
            {
                continue;
            }
            String[] key_value = request[j].split(":");
            headers.put(key_value[0],key_value[1]);
        }
        httpRequst.setHeaders(headers);

        StringBuilder sb = new StringBuilder();
        for (int j = bodyIndex+1; j < request.length; j++)
        {
            sb.append(request[j]);
        }

        httpRequst.setBody(sb.toString());
        if(request.length!=0)
        {
            String resource = request[0];
            String[] resources = resource.split(" ");
            String type = resources[0];
            String path = resources[1];
            httpRequst.setProtocol(type);
            httpRequst.setRequrl(path);
        }
        System.out.println(httpRequst.toString());
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
