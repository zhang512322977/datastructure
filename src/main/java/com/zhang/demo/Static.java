package com.zhang.demo;

public class Static {


    public static String getData()
    {
        return "123";
    }


    public static String getUser(User user)
    {
        System.out.println(user);
        return "123";
    }



    public static String getUser(User user,String id)
    {
        return "123";
    }

    public static User getUser(String id,String name)
    {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
}
