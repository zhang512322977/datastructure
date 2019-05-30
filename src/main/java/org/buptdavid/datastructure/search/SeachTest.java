package org.buptdavid.datastructure.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: zhangdong
 * @Date: 2019/5/17 21:29
 * @Description:
 */
public class SeachTest {

    static List<String> datas = new ArrayList<>();

    static List<String> resultdatas = new ArrayList<>();

    static List<String> resultdatas1 = new ArrayList<>();

    static List<String> resultdatas2 = new ArrayList<>();

    static List<String> resultdatas3 = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        datas.add("content-service");
        datas.add("search-service");
        datas.add("product-service");
        datas.add("cpu");
        datas.add("hotwords");
        datas.add("mqprocess");
        datas.add("spaces");
        datas.add("test");
        datas.add("cgw");
        datas.add("Content");
        datas.add("product");
        datas.add("ms-content-service");
        datas.add("ms-selection-service");

        while (sc.hasNext())
        {
            resultdatas.clear();
            String name = sc.next();

            for (String data:datas) {

                //一级匹配 完全匹配
                if(data.equalsIgnoreCase(name))
                {
                    resultdatas.add(data);
                }


            }
            datas.removeAll(resultdatas);
            System.out.println(datas);
            for (String data : datas) {
                //二级搜索 包含匹配

                if(data.contains(name))
                {
                    resultdatas1.add(data);
                }
            }
            datas.removeAll(resultdatas1);
            for (String data : datas) {
                //二级搜索 包含匹配
                if(Match.match(0.25,data,name))
                {
                    resultdatas2.add(data);
                }
            }
            datas.removeAll(resultdatas2);

            System.out.println(resultdatas);

            System.out.println(resultdatas1);
            System.out.println(resultdatas2);
            System.out.println(datas);

        }





    }
}
