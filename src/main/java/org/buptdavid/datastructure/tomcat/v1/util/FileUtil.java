package org.buptdavid.datastructure.tomcat.v1.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {

    public  static List<String> getListFromFile(String path)
    {
        List<String> lines = new ArrayList();
        File file = new File(path);
        try (FileInputStream in = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(in);
             BufferedReader br = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line= br.readLine())!=null)
            {
                lines.add(line);
            }
            return lines;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return lines;

    }

    public  static String readFileToString(String path)
    {
        File file = new File(path);
        StringBuffer buffer = new StringBuffer();
        try (FileInputStream in = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(in);
             BufferedReader br = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line= br.readLine())!=null)
            {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return buffer.toString();
    }


}
