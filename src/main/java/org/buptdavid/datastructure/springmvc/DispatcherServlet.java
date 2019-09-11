package org.buptdavid.datastructure.springmvc;

import org.buptdavid.datastructure.log.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class DispatcherServlet extends HttpServlet
{

    private Properties properties = new Properties();
    @Override
    public void init()
    {
        ServletConfig servletConfig = getServletConfig();

        ServletContext servletContext = getServletContext();

        String configLocation = servletConfig.getInitParameter("contextConfigLocation");

        loadConfig(configLocation);


        doScanner(properties.getProperty("scanPackage"));

        doInstance();

        initHandlerMapping();


    }

    private void initHandlerMapping()
    {
    }

    private void doInstance()
    {
    }

    private void doScanner(String scanPackage)
    {
        Logger.debug("Enter doScanner scanPackage=",scanPackage);
        URL url  =this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.", "/"));

    }

    private void loadConfig(String configLocation)
    {
        InputStream inputStream = getClass().getResourceAsStream(configLocation);
        try
        {
            properties.load(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(inputStream!=null)
                {
                    inputStream.close();
                    inputStream=null;
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
