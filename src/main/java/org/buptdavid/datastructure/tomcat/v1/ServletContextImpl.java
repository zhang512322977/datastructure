package org.buptdavid.datastructure.tomcat.v1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServletContextImpl
{

    private Map<String, ServletConfigInfo> servletConfigHashMap = new HashMap<>();

    private Map<String,HttpServlet> httpServletMap = new HashMap<>();

    public void init()
    {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("web.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try
        {
            builder = factory.newDocumentBuilder();
            if (resourceAsStream==null)
            {
                return;
            }
            Document doc = builder.parse(resourceAsStream);
            dealServlet(doc);
            dealMapping(doc);

            Set<String> servletNames = servletConfigHashMap.keySet();

            for (String servletName : servletNames)
            {
                ServletConfigInfo servletConfigInfo = servletConfigHashMap.get(servletName);

                HttpServlet httpServlet = getInstence(servletConfigInfo);

                httpServletMap.put(servletConfigInfo.getUrlPatten(),httpServlet);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public HttpServlet getServlet(String path)
    {

        Set<String> keySet = httpServletMap.keySet();
        for (String key : keySet)
        {
            if(key.equals(path))
            {
                return httpServletMap.get(key);
            }
        }
        return httpServletMap.get("/*");
    }
    private void dealServlet(Document doc)
    {
        NodeList servlets = doc.getElementsByTagName("servlet");
        if(servlets==null)
        {
            return;
        }
        for (int i = 0; i < servlets.getLength(); i++)
        {
            Node item = servlets.item(i);
            NodeList childNodes = item.getChildNodes();
            if(childNodes==null)
            {
               continue;
            }
            ServletConfigInfo servletConfigInfo = new ServletConfigInfo();
            for (int j = 0; j < childNodes.getLength(); j++)
            {
                String servletName;
                String servletClass;
                Node item1 = childNodes.item(j);


                if("servlet-name".equals(item1.getNodeName()))
                {
                    servletName = item1.getTextContent();
                    servletConfigInfo.setServletName(servletName);
                }
                if("servlet-class".equals(item1.getNodeName()))
                {
                    servletClass = item1.getTextContent();
                    servletConfigInfo.setServletClazz(servletClass);
                }
                if("init-param".equals(item1.getNodeName()))
                {
                    NodeList childNodes1 = item1.getChildNodes();
                    String key = "";
                    String value = "";
                    for (int k = 0; k < childNodes1.getLength(); k++)
                    {
                        Node item2 = childNodes1.item(k);
                        if("param-name".equals(item2.getNodeName()))
                        {
                            key = item2.getTextContent();

                        }
                        if("param-value".equals(item2.getNodeName()))
                        {
                            value = item2.getTextContent();

                        }
                    }
                    servletConfigInfo.addInitParams(key,value);
                }
            }
            servletConfigHashMap.put(servletConfigInfo.getServletName(),servletConfigInfo);

        }
    }

    private void dealMapping(Document doc)
    {

        NodeList servletMappings = doc.getElementsByTagName("servlet-mapping");
        if(servletMappings==null)
        {
            return;
        }
        for (int i = 0; i < servletMappings.getLength(); i++)
        {
            Node item = servletMappings.item(i);
            NodeList childNodes = item.getChildNodes();
            if(childNodes!=null)
            {
                String servletName = "";
                String urlPatten = "";
                for (int j = 0; j < childNodes.getLength(); j++)
                {
                    Node item1 = childNodes.item(j);
                    if("servlet-name".equals(item1.getNodeName()))
                    {
                        servletName = item1.getTextContent();
                    }
                    if("url-pattern".equals(item1.getNodeName()))
                    {
                        urlPatten = item1.getTextContent();
                    }
                }
                ServletConfigInfo servletConfigInfo = servletConfigHashMap.get(servletName);
                servletConfigInfo.setUrlPatten(urlPatten);
            }
        }
    }

    private HttpServlet getInstence(ServletConfigInfo servletConfigInfo)
    {

        try
        {
            Map<String,String> initParams = new HashMap<>();

            Class clasz = Class.forName(servletConfigInfo.getServletClazz());

            return (HttpServlet)clasz.newInstance();

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
