package org.buptdavid.datastructure.tomcat.v1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServletConfigImpl implements ServletConfig
{
    String servletName;

    ServletContext servletContext;

    Map<String,String> initParameters = new HashMap<>();

    public void setServletName(String servletName)
    {
        this.servletName = servletName;
    }

    public void setServletContext(ServletContext servletContext)
    {
        this.servletContext = servletContext;
    }

    public void setInitParameters(Map<String, String> initParameters)
    {
        this.initParameters = initParameters;
    }

    @Override
    public String getServletName()
    {
        return servletName;
    }

    @Override
    public ServletContext getServletContext()
    {
        return servletContext;
    }

    @Override
    public String getInitParameter(String name)
    {
        return initParameters.get(name);
    }

    @Override
    public Enumeration getInitParameterNames()
    {
        return null;
    }
}
