package org.buptdavid.datastructure.array;

/**
 * 对于数组的封装
 * 数组的操作：<br/>
 * 1.初始化
 * 2.添加元素
 * 3.查询元素
 * 4.删除元素
 */
public class MyArray {

    private Object[] array;
    private int index;

    public MyArray()
    {
        array = new Object[10];
    }

    public int getSize()
    {
        return index;
    }

    /**
     * 添加元素
     * @param item
     * @return
     */
    public int addItem(Object item)
    {
        if(index >= array.length)
        {
            return -1;
        }
        array[index] = item;
        index++;
        return index;
    }

    /**
     *  根据下标查询
     * @param index
     * @return
     */
    public Object getItem(int index)
    {
        if(index>=array.length)
        {
            return null;
        }
        return array[index];
    }

    /**
     * 是否包含
     * @param item
     * @return
     */
    public boolean contain(Object item)
    {
        if (getIndex(item)>=0)
        {
            return true;
        }
        return false;
    }


    /**
     * 获取下标
     * @param item
     * @return
     */
    public int getIndex(Object item)
    {
        for (int i = 0; i <=index; i++) {
            if (item.equals(getItem(i)))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素
     * @param item
     * @return
     */
    private int deleteItem(Object item)
    {
        for (int i = 0; i < index; i++) {
            Object temp = getItem(i);
            if(temp.equals(item))
            {
                array[i] = array[i+1];
            }
        }
        index--;
        return -1;
    }



}
