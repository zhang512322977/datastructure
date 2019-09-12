package org.buptdavid.datastructure.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetServiceDSF
{


    public static String doPostTestFour(String url,String params) {

        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost(url+ "?" + params);

        // 设置ContentType(注:如果只是传普通参数的话,ContentType不一定非要用application/json)
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");


        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            //System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                //System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                String str = EntityUtils.toString(responseEntity);
                //System.out.println("响应内容为:" + str);
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "";
    }


    public void getData()
    {
        String data = doPostTestFour("http:///dsfcallweb/getServicesByModel.html","modelName=product");

        JSONArray objects = JSON.parseArray(data);

        for (int i = 0; i < objects.size(); i++)
        {
            String service = objects.getString(i);

            String str = doPostTestFour("http:///dsfcallweb/getMethodsByService.html","serviceName="+service);
            //System.out.println(service + ":" + str);

            System.out.println(service);
            JSONArray da = JSON.parseArray(str);

            System.out.println();
            String res = service;
            for (int j = 0; j < da.size(); j++)
            {
                String methods = da.getString(j);
                System.out.println(methods);
            }
            System.out.println();

        }

    }
    public static void main(String[] args)
        throws IOException
    {
        getDataFromHtml();
    }




    public  static List getDataFromHtml()
        throws IOException
    {
        List modelName = new ArrayList();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建参数队列
        String url = "http:///dsfcallweb/dsfCallView.html";
        // 创建httpget.
        HttpGet httpget = new HttpGet(url);
       // System.out.println("executing request " + httpget.getURI());
        // 执行get请求.
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容长度
                //System.out.println("Response content length: " + entity.getContentLength());
                // 打印响应内容
                String str = EntityUtils.toString(entity);
                //System.out.println("Response content: " + str);
                Document doc = Jsoup.parse(str);

                Element elements = doc.getElementById("modelName");

                //System.out.println(elements.toString());
                Elements children = elements.children();
                for (int i = 0; i < children.size(); i++)
                {
                    Element element = children.get(i);
                    String data = element.data();
                    System.out.println(element.ownText());
                    modelName.add(element.ownText());
                }

            }


        } finally {
            response.close();
        }
        return modelName;
    }

}
