package com.zhang.demo;

import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();
    private RandomUtil(){}

    public static Random getRandomInstance()
    {
        return random;
    }



}
