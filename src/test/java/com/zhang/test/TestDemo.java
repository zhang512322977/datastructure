package com.zhang.test;


import com.zhang.demo.Static;
import com.zhang.demo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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





}
