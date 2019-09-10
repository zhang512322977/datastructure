package org.buptdavid.datastructure.string;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class StringCast {

    public static void main(String[] args) {
        Class classes = QqConfigValue.class;

        Field[] fields = classes.getDeclaredFields();

        Map map = new HashMap();
        for (Field field:fields) {
            String name = field.getName();
            // System.out.println("public static final String " + name.toUpperCase()+"_KEY = \"ys.\";");
            //System.out.println("public static final String " + name.toUpperCase()+"_DEFAULT = \"\";");
            if(name.contains("KEY"))
            {
                //setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/book.ys.pool.thread.num' '/nap/'

               System.out.println("System.out.println(\"setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/\"+ QqConfigValue."+name+"+\"' 'aaaaa'\" );");
            }

        }
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_ORDERTYPE_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_SOURCETYPE_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_COMPANYNAME_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_IP_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_PORT_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_USERNAME_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_USERPWD_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_METAPATH_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_CHAPTERPATH_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_ENCODING_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_METAFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_ALLMETAFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_CHAPTERFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_ALLCHAPTERFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.QQ_COOPARAMBID_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_ORDERTYPE_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_SOURCETYPE_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_COMPANYNAME_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_IOSDOWNLOADURL_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_IOSLINKURL_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_ANDROIDLINKURL_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_ANDROIDDOWNLOADURL_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_IP_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_PORT_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_USERNAME_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_USERPWD_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_METAPATH_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_CHAPTERPATH_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_ENCODING_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_METAFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_ALLMETAFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_CHAPTERFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_ALLCHAPTERFILEPREFIX_KEY+"' 'aaaaa'" );
        System.out.println("setvalue $1 $2 '/apps/thirdparty-timertask-service/config/default/"+ QqConfigValue.YS_COOPARAMBID_KEY+"' 'aaaaa'" );

    }


    public static void test1()
    {
        Class classes = YsConfigValue.class;

        Field[] fields = classes.getDeclaredFields();

        for (Field field:fields) {
            String name = field.getName().replaceAll("ys","ys_");
            // System.out.println("public static final String " + name.toUpperCase()+"_KEY = \"ys.\";");
            //System.out.println("public static final String " + name.toUpperCase()+"_DEFAULT = \"\";");
            System.out.println();
        }

        for (Field field:fields) {
            String name1 = field.getName().replaceAll("ys","Ys");
            String name = field.getName().replaceAll("ys","ys_");
            String key = name.toUpperCase()+"_KEY";
            String value = name.toUpperCase()+"_DEFAULT";
            System.out.println("    public static String get"+name1+"() {");
            System.out.println("return  EtcdConfig.getAppConfig("+key+","+value+");}");
            System.out.println();
        }
    }

    public static void test2()
    {
        Class classes = QqConfigValue.class;

        Field[] fields = classes.getDeclaredFields();

        for (Field field:fields) {
            String name = field.getName().replaceAll("qq","qq_");
            // System.out.println("public static final String " + name.toUpperCase()+"_KEY = \"ys.\";");
            //System.out.println("public static final String " + name.toUpperCase()+"_DEFAULT = \"\";");
            System.out.println();
        }

        for (Field field:fields) {
            String name1 = field.getName().replaceAll("qq","Qq");
            String name = field.getName().replaceAll("qq","qq_");
            String key = name.toUpperCase()+"_KEY";
            String value = name.toUpperCase()+"_DEFAULT";
            System.out.println("    public static String get"+name1+"() {");
            System.out.println("return  EtcdConfig.getAppConfig("+key+","+value+");}");
            System.out.println();
        }

    }
}
