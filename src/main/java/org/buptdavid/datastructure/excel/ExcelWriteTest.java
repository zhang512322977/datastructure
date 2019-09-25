package org.buptdavid.datastructure.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.buptdavid.datastructure.http.GetServiceDSF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.buptdavid.datastructure.http.GetServiceDSF.doPostTestFour;

public class ExcelWriteTest {

    public static void writeWithoutHead() throws IOException {
        try (OutputStream out = new FileOutputStream("E:\\ideaworkspace\\datastructure\\src\\main\\resources\\withHead.xlsx");) {

            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            List<String> modelName = GetServiceDSF.getDataFromHtml();

            for (int i = 0; i < modelName.size(); i++)
            {
                String model = modelName.get(i);
                if(model==null|| model.equals("")||"请选择".equals(model)||model.contains(".txt")||"huy".equals(model))
                {
                    continue;
                }
                List datas = getData(model);
                if(datas==null)
                {
                    continue;
                }
                Sheet sheet1 = new Sheet(i+1, 0);
                sheet1.setSheetName(model);

                List<List<String>> head = new ArrayList<List<String>>();
                List<String> headCoulumn1 = new ArrayList<String>();
                List<String> headCoulumn2 = new ArrayList<String>();
                List<String> headCoulumn3 = new ArrayList<String>();
                headCoulumn1.add("服务名称");
                headCoulumn2.add("接口名");
                headCoulumn3.add("复杂度（高、中、低）");
                head.add(headCoulumn1);
                head.add(headCoulumn2);
                head.add(headCoulumn3);
                Table table = new Table(1);
                table.setHead(head);
                writer.write0(datas, sheet1, table);
            }
            writer.finish();

        }
    }

    public static List getData(String modelName)
    {

        System.out.println(modelName);
        List<List<String>> datas = new ArrayList<>();
        String data = doPostTestFour("http:///dsfcallweb/getServicesByModel.html","modelName="+modelName);

        System.out.println(data);
        if(data==null||"".equals(data))
        {
            return null;
        }

        JSONArray objects = JSON.parseArray(data);

        for (int i = 0; i < objects.size(); i++)
        {
            String service = objects.getString(i);

            String str = doPostTestFour("http:///dsfcallweb/getMethodsByService.html","serviceName="+service);
            //System.out.println(service + ":" + str);

            //System.out.println(service);
            JSONArray da = JSON.parseArray(str);

            //System.out.println();
            for (int j = 0; j < da.size(); j++)
            {
                List<String> row = new ArrayList<>();
                if (j==0)
                {
                    row.add(service);
                }else{
                    row.add("");
                }
                String methods = da.getString(j);
                row.add(methods);

                datas.add(row);
                //System.out.println(methods);
            }
            //System.out.println();

        }

        return datas;


    }


    public static void main(String[] args)
        throws IOException
    {

        File file = new File("");

        FileOutputStream fileOutputStream = new  FileOutputStream(file);


        writeWithoutHead();
    }
}
