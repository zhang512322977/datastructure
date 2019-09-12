package org.buptdavid.datastructure.tomcat.v1;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class HttpServletResponseImpl implements HttpServletResponse
{

    private ServletOutputStream outputStream;

    private Map<String,String> respHeaders = new HashMap();

    public HttpServletResponseImpl(ServletOutputStream outputStream)
    {
        this.outputStream = outputStream;
        respHeaders.put("Content-Type","text/html;charset=utf-8");
        respHeaders.put("Server","Apache-Coyote/1.1");
    }

    public void setOutputStream(ServletOutputStream outputStream)
    {
        this.outputStream = outputStream;
    }

    @Override
    public void addCookie(Cookie cookie)
    {

    }

    @Override
    public boolean containsHeader(String name)
    {
        return respHeaders.containsKey(name);
    }

    @Override
    public String encodeURL(String url)
    {
        return null;
    }

    @Override
    public String encodeRedirectURL(String url)
    {
        return null;
    }

    @Override
    public String encodeUrl(String url)
    {
        return null;
    }

    @Override
    public String encodeRedirectUrl(String url)
    {
        return null;
    }

    //https://www.runoob.com/http/http-status-codes.html
    @Override
    public void sendError(int sc, String msg)
        throws IOException
    {
        OutputStream os = getOutputStream();
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1");
        sb.append(" ");
        sb.append(sc);
        sb.append(" ");
        sb.append("Bad Request");
        sb.append("\n");
        os.write(sb.toString().getBytes());
        StringBuilder headers = new StringBuilder();
        Set<String> headKey = respHeaders.keySet();
        for (String key : headKey)
        {
            headers.append(key);
            headers.append(":");
            headers.append(respHeaders.get(key));
            headers.append("\n");
        }
        os.write("\n\n".getBytes());
        os.write(msg.getBytes("utf-8"));
        os.flush();
    }

    @Override
    public void sendError(int sc)
        throws IOException
    {
        sendError(sc,"");
    }

    @Override
    public void sendRedirect(String location)
        throws IOException
    {

    }

    @Override
    public void setDateHeader(String name, long date)
    {

    }

    @Override
    public void addDateHeader(String name, long date)
    {

    }

    @Override
    public void setHeader(String name, String value)
    {

    }

    @Override
    public void addHeader(String name, String value)
    {

    }

    @Override
    public void setIntHeader(String name, int value)
    {

    }

    @Override
    public void addIntHeader(String name, int value)
    {

    }

    @Override
    public void setStatus(int sc)
    {

    }

    @Override
    public void setStatus(int sc, String sm)
    {

    }

    @Override
    public String getCharacterEncoding()
    {
        String contentType = getContentType();

        String temp[] = contentType.split(";");

        if(temp.length==2)
        {
            String chartSet = temp[1].split("=")[2];

            return chartSet;
        }
        return respHeaders.get("chartSet");

    }

    @Override
    public String getContentType()
    {
        return respHeaders.get("Content-Type");
    }

    @Override
    public ServletOutputStream getOutputStream()
        throws IOException
    {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1");
        sb.append(" ");
        sb.append(200);
        sb.append(" ");
        sb.append("ok");
        sb.append("\n");
        outputStream.write(sb.toString().getBytes());
        StringBuilder headers = new StringBuilder();
        Set<String> headKey = respHeaders.keySet();
        for (String key : headKey)
        {
            headers.append(key);
            headers.append(":");
            headers.append(respHeaders.get(key));
            headers.append("\n");
        }
        outputStream.write(headers.toString().getBytes());
        outputStream.write("\n".getBytes());
        return outputStream;
    }

    @Override
    public PrintWriter getWriter()
        throws IOException
    {
        PrintWriter printWriter = new PrintWriter(outputStream);

        return printWriter;
    }

    @Override
    public void setCharacterEncoding(String charset)
    {
        respHeaders.put("chartSet",charset);
    }

    @Override
    public void setContentLength(int len)
    {

    }

    @Override
    public void setContentType(String type)
    {
        respHeaders.put("Content-Type",type);
    }

    @Override
    public void setBufferSize(int size)
    {

    }

    @Override
    public int getBufferSize()
    {
        return 0;
    }

    @Override
    public void flushBuffer()
        throws IOException
    {
        getOutputStream().flush();
    }

    @Override
    public void resetBuffer()
    {

    }

    @Override
    public boolean isCommitted()
    {
        return false;
    }

    @Override
    public void reset()
    {

    }

    @Override
    public void setLocale(Locale loc)
    {

    }

    @Override
    public Locale getLocale()
    {
        return null;
    }
}
