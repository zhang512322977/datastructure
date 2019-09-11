package org.buptdavid.datastructure.tomcat.v1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HttpServletRequstImpl implements HttpServletRequest
{

    Map<String,String> headers = new HashMap<>();


    private String protocol;

    private String requrl;

    private String body;

    public void setBody(String body)
    {
        this.body = body;
    }

    public String getRequrl()
    {
        return requrl;
    }

    public String getBody()
    {
        return body;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public void setRequrl(String requrl)
    {
        this.requrl = requrl;
    }

    public void setHeaders(Map<String, String> headers)
    {
        this.headers = headers;
    }

    @Override
    public Object getAttribute(String name)
    {
        return null;
    }

    @Override
    public Enumeration getAttributeNames()
    {
        return null;
    }

    @Override
    public String getCharacterEncoding()
    {
        return null;
    }

    @Override
    public void setCharacterEncoding(String env)
        throws UnsupportedEncodingException
    {

    }

    @Override
    public int getContentLength()
    {
        return Integer.valueOf(headers.get("Content-Length"));
    }

    @Override
    public String getContentType()
    {
        return headers.get("ContentType");
    }

    @Override
    public ServletInputStream getInputStream()
        throws IOException
    {
        return null;
    }

    @Override
    public String getParameter(String name)
    {
        return null;
    }

    @Override
    public Enumeration getParameterNames()
    {
        return null;
    }

    @Override
    public String[] getParameterValues(String name)
    {
        return new String[0];
    }

    @Override
    public Map getParameterMap()
    {
        return null;
    }

    @Override
    public String getProtocol()
    {
        return protocol;
    }

    @Override
    public String getScheme()
    {
        return null;
    }

    @Override
    public String getServerName()
    {
        return null;
    }

    @Override
    public int getServerPort()
    {
        return 0;
    }

    @Override
    public BufferedReader getReader() throws IOException
    {
        return null;
    }

    @Override
    public String getRemoteAddr()
    {
        return null;
    }

    @Override
    public String getRemoteHost()
    {
        return null;
    }

    @Override
    public void setAttribute(String name, Object o)
    {

    }

    @Override
    public void removeAttribute(String name)
    {

    }

    @Override
    public Locale getLocale()
    {
        return null;
    }

    @Override
    public Enumeration getLocales()
    {
        return null;
    }

    @Override
    public boolean isSecure()
    {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path)
    {
        return null;
    }

    @Override
    public String getRealPath(String path)
    {
        return null;
    }

    @Override
    public int getRemotePort()
    {
        return 0;
    }

    @Override
    public String getLocalName()
    {
        return null;
    }

    @Override
    public String getLocalAddr()
    {
        return null;
    }

    @Override
    public int getLocalPort()
    {
        return 0;
    }


    @Override
    public String getAuthType()
    {
        return null;
    }

    @Override
    public Cookie[] getCookies()
    {
        return new Cookie[0];
    }

    @Override
    public long getDateHeader(String name)
    {
        return 0;
    }

    @Override
    public String getHeader(String name)
    {
        return headers.get(name);
    }

    @Override
    public Enumeration getHeaders(String name)
    {
        return null;
    }

    @Override
    public Enumeration getHeaderNames()
    {
        return null;
    }

    @Override
    public int getIntHeader(String name)
    {
        return 0;
    }

    @Override
    public String getMethod()
    {
        return protocol;
    }

    @Override
    public String getPathInfo()
    {
        return null;
    }

    @Override
    public String getPathTranslated()
    {
        return null;
    }

    @Override
    public String getContextPath()
    {
        return requrl;
    }

    @Override
    public String getQueryString()
    {
        return body;
    }

    @Override
    public String getRemoteUser()
    {
        return null;
    }

    @Override
    public boolean isUserInRole(String role)
    {
        return false;
    }

    @Override
    public Principal getUserPrincipal()
    {
        return null;
    }

    @Override
    public String getRequestedSessionId()
    {
        return null;
    }

    @Override
    public String getRequestURI()
    {
        return null;
    }

    @Override
    public StringBuffer getRequestURL()
    {
        return null;
    }

    @Override
    public String getServletPath()
    {
        return requrl;
    }

    @Override
    public HttpSession getSession(boolean create)
    {
        return null;
    }

    @Override
    public HttpSession getSession()
    {
        return null;
    }

    @Override
    public boolean isRequestedSessionIdValid()
    {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie()
    {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL()
    {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromUrl()
    {
        return false;
    }
}
