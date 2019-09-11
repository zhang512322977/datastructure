package org.buptdavid.datastructure.tomcat.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServletConfigInfo
{
    private String servletName;

    private String servletClazz;

    private String urlPatten;


    private Map<String,String> initParams = new HashMap<>();

    public void addInitParams(String key,String value)
    {
        initParams.put(key,value);
    }
}
