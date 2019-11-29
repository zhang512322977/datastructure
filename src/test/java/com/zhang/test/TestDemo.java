package com.zhang.test;


import com.zhang.demo.RandomUtil;
import com.zhang.demo.Static;
import com.zhang.demo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Static.class)
public class TestDemo {


    @Before
    public void setUp()
    {

    }


    /**
     * Mocking Static Method
     */
    @Test
    public void test()
    {
        mockStatic(Static.class);

        when(Static.getData()).thenReturn("345");
        System.out.println(Static.getData());
        User user = new User();
        when(Static.getUser(user)).thenReturn("678");

        System.out.println(Static.getUser(user));
        User user1 = new User();
        System.out.println(Static.getUser(user1));







    }



    @Test
    public void test1()
    {

        List<String> a = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            a.add("1111"+i);
        }

        List<String> cc = new ArrayList<>();
        for (int j = 0; j < 2000; j++) {
            cc.add("2222"+j);
        }


        List<String> b= new ArrayList<>();
        long start = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < 4; i++) {
            getRandomBook(a,b);
        }
        long end = System.currentTimeMillis();
        System.out.println(b);
        System.out.println(end-start);

/*        List<Set> aa = new ArrayList<>();
        Set bb = new HashSet(a);
        aa.add(bb);
        aa.add(bb);


        List<String> currentBookIds = new ArrayList<>();
        for (int i = 0; currentBookIds.size() < 4; i++) {
            //所有专区都没找够4本书，重新开始找
            if (i >= aa.size()) {
                i = 0;
            }
            Set bookset = aa.get(i);
            if(bookset==null)
            {
                continue;
            }
            List<String> bookSet = new ArrayList<>(bookset);

            getRandomBook(bookSet, currentBookIds);
        }
        System.out.println(currentBookIds);*/

    }
    @Test
    public void test2()
    {

        List<String> a = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            a.add("1111"+i);
        }

        List<String> cc = new ArrayList<>();
        for (int j = 0; j < 20000; j++) {
            cc.add("2222"+j);
        }


        List<List> aa = new ArrayList<>();
        List bb = new ArrayList(a);
        List dd = new ArrayList(cc);
        aa.add(bb);
        aa.add(dd);

        long start = System.currentTimeMillis();

        List<String> currentBookIds = new ArrayList<>();
        //取取空的专区数量
        int emptyNodeSize = 0;
        for (int i = 0; currentBookIds.size() < 4; i++) {
            //所有专区都没找够4本书，重新开始找
            if (i >= aa.size()) {
                i = 0;
            }
            if(emptyNodeSize == aa.size())
            {
                break;
            }
            List<String> books = aa.get(i);
            //该专区下的图书已经被取完
            if(books.size()==0)
            {
                emptyNodeSize++;
                continue;
            }
            getRandomBook(books, currentBookIds);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(currentBookIds);

    }

    /**
     * 获取随机的一本书
     *
     * @param bookids 需要选择的图书列表
     * @param currentBookIds 获取的图书列表
     */
    private static void getRandomBook(List<String> bookids, List<String> currentBookIds) {

        int size = bookids.size();
        if (size == 0) {
            return;
        }
        Random random = RandomUtil.getRandomInstance();
        int randomIndex = random.nextInt(size);
        if (0 <= randomIndex && randomIndex < size)
        {
            String bookId = bookids.get(randomIndex);
            if (currentBookIds.contains(bookId)) {
                bookids.remove(bookId);
                getRandomBook(bookids, currentBookIds);
            } else {
                bookids.remove(bookId);
                currentBookIds.add(bookId);
            }
        } else {
            getRandomBook(bookids, currentBookIds);
        }
    }




}
