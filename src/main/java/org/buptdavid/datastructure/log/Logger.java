package org.buptdavid.datastructure.log;

public class Logger
{
    public static void debug(Object... ob)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("debug[");
        for (Object o: ob)
        {
            sb.append(o);
        }
        sb.append("]");
        System.out.println(sb);
    }

}
