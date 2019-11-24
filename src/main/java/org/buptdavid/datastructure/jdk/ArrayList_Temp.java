package org.buptdavid.datastructure.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangdong
 * @Date: 2019/8/29 23:12
 * @Description:
 */
public class ArrayList_Temp extends ArrayList {


    @Override
    public boolean add(Object o) {


        return super.add(o);
    }

    public static void main(String[] args) {
        List array = new ArrayList_Temp();

        array.add("123");

        System.out.println(array);


    }





}
