package org.buptdavid.datastructure.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConsistentHashPool
{
    private static final int BUCKETS_BASE = 65536;

    public static void main(String[] args)
        throws NoSuchAlgorithmException
    {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] a = new byte[16];
        for (int i = 0;i<4;i++)
        {
            byte[] d = md5.digest(("127.0.0.1:8080-"+i).getBytes());
            System.out.println(new String(d));
            System.out.println(digestInt(d,0));;
            System.out.println(digestInt(d,1));;
            System.out.println(digestInt(d,2));;
            System.out.println(digestInt(d,3));;
        }


        byte b = 1;
        System.out.println(b & 0x7F);

    }

    public static int digestInt(byte[] d, int seq) {
        int offset = seq * 4;
        int k = (d[offset + 3] & 0x7F) << 24;
        k |= (d[offset + 2] & 0xFF) << 16;
        k |= (d[offset + 1] & 0xFF) << 8;
        k |= (d[offset + 0] & 0xFF);
        return (k % BUCKETS_BASE);
    }
}
