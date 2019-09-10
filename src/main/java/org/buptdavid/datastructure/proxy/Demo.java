package org.buptdavid.datastructure.proxy;

public class Demo {

    public static void main(String[] args) {
        int num = 100;
        int j = 0;
        int k = 0;
        for (int i = 2; i < num;i++) {
            //1000 2
            System.out.println("INSERT INTO CON_RAC_CONTENT_INFO VALUES("+(1000+k)+",'1','"+i+"','1','123','zd', to_date ( '2019-07-05 14:56:03' , 'YYYY-MM-DD HH24:MI:SS' ));");

            //2
            System.out.println("INSERT INTO CON_RANK_AND_CATEGORY_CATALOG VALUES("+i+",'全部分类','2','1','2','1','0','11551','1','zd',to_date ( '2019-07-05 14:56:03' , 'YYYY-MM-DD HH24:MI:SS' ));");
            //1000
            System.out.println("INSERT INTO CON_RAC_CONTENT_IMAGE VALUES("+(1000+k)+",'5539fae9a36ba9a70553a0054be22905d255ff8de12b','.jpg','https://exmail.qq.com/','5539fae9a36ba9a70553a0054be8dd05d25bdd38406b','.jpg','https://exmail.qq.com/',"+(i-1)+");");

            //1001 0 2
            k++;
            getData(k,j++,i,0);
            k++;
            //1002 1 2
            getData(++k,j++,i,0);
            k++;
            //1003 2 2
            getData(++k,j++,i,1);
            k++;
            //1004 3 2
            getData(++k,j++,i,1);


            k++;

        }



    }

    public static void getData(int i,int j,int k,int isugc)
    {
        System.out.println("INSERT INTO CON_RAC_CONTENT_INFO VALUES("+(1000+i)+",'2','"+k+"','1','123','zd', to_date ( '2019-07-05 14:56:03' , 'YYYY-MM-DD HH24:MI:SS' ));");

        System.out.println("INSERT INTO CON_RAC_CONTENT_CATEGORY VALUES("+(1000+i)+",'科幻"+j+"','1','1.5@3417#','15697968','0','1'，'10'，'free','0','0','1','1','0','0','1','1','1','393826032,382678583,394323367,372280969,371741031,403088075,393535368,346574677','1','"+isugc+"','5539fae9a36ba9a70553a0054be8dd05d281707edaae','.jpg','1','recommendsection1','recommendsection2','recommendsection3','recommendsection4','123','831208678',2);");
    }

}
