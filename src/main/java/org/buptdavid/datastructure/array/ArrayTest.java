package org.buptdavid.datastructure.array;


/**
 * 数据结构的操作：
 * 初始化：内存消耗 时间消耗
 * 查询：
 *  单元素查询
 *  列表查询
 * 新增：
 *  扩容
 *  修改
 * 删除：
 *   减容
 *
 *
 *   优点：1、按照索引操作十分方便，包括修改和读取
 *   缺点：不具备伸缩性  存储类型单一：只能存储一种类型的数据
 *  使用的场景：对存储要求不高，频繁查询，很少新增和删除的场景
 *
 */
public class ArrayTest {

    public static void main(String[] args) {

        //数组的初始化   --数组初始化之后就有默认值
        System.out.println("数组的初始化...");
        int a[] = new int[10];


        //遍历
        System.out.println("查询遍历");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }

        //查询 某个元素 ---很快
        System.out.println("单元素查询");
        System.out.println(a[0]);
        //修改 --很快
        System.out.println("修改");
        a[0] = 1;
        //查询
        System.out.println(a[0]);


    }


}
