package org.buptdavid.datastructure.sort;

/**
 * 排序算法的接口
 * @author weijielu
 */
public interface ISort {


	/**
	 * 对数组array进行升序排序
	 * @param array
	 */
	public void sort(int[] array);

	public default  void changeItem(int[] array,int i,int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
