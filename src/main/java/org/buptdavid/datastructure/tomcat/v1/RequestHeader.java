package org.buptdavid.datastructure.tomcat.v1;

import org.buptdavid.datastructure.tomcat.v1.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface RequestHeader {
    public final String ACCEPT = "Accept";
    public final String ACCEPT_CHARSET = "Accept-Charset";
    public final String ACCEPT_ENCODING = "Accept-Encoding";
    public final String ACCEPT_LANGUAGE = "Accept-Language";
    public final String ACCEPT_RANGES = "Accept-Ranges";
    public final String AUTHORIZATION = "Authorization";
    public final String CACHE_CONTROL = "Cache-Control";
    public final String CONNECTION = "Connection";
    public final String COOKIE = "Cookie";
    public final String CONTENT_LENGTH = "Content-Length";
    public final String CONTENT_TYPE = "Content-Type";
    public final String DATE = "Date";
    public final String EXPECT = "Expect";
    public final String FROM = "From";
    public final String HOST = "Host";
    public final String IF_MATCH = "If-Match";
    public final String IF_MODIFIED_SINCE = "If-Modified-Since";
    public final String IF_NONE_MATCH = "If-None-Match";
    public final String IF_RANGE = "If-Range";
    public final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
    public final String MAX_FORWARDS = "Max-Forwards";
    public final String PRAGMA = "Pragma";
    public final String PROXY_AUTHORIZATION = "Proxy-Authorization";
    public final String RANGE = "Range";
    public final String REFERER = "Referer";
    public final String TE = "TE";
    public final String UPGRADE = "Upgrade";
    public final String USER_AGENT = "User-Agent";
    public final String VIA = "Via";
    public final String WARNING = "Warning";


    public static void main(String[] args) {

        List<String> values = getValue();
        for (String value :values) {
            if(value!=null&& !value.equals(""))
            {
                String name = getName(value);
                System.out.println("public final String "+ name +" = \"" + value+"\";");
            }
        }


    }

    static String getName(String value) {
        if(value.contains("-"))
        {
            String[] temp = value.split("-");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]);
                if(i==temp.length-1)
                {
                    return sb.toString().toUpperCase();
                }else
                    {
                        sb.append("_");
                    }
            }
        }
        return value.toUpperCase();
    }

    static List getValue() {
        List<String> value = FileUtil.getListFromFile("");
        return value;
    }


}
