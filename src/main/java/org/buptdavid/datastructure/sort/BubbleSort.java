package org.buptdavid.datastructure.sort;

/**
 * 冒泡排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 * @author weijielu
 * @see ISort
 * @see SortTest
 */
public class BubbleSort implements ISort {

	@Override
	public void sort(int[] array) {
		sort1(array);
	}

	private void sort1(int[] array)
	{
		int temp = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length - 1; j++){
				if(array[j] > array[j + 1]){
					changeItem(array,i,j+1);
				}
			}
		}
	}


	private void sort2(int[] array)
	{
		int len = array.length;
		//轮数
		for (int i = 0; i <len; i++) {
			//从第一个开始和前一个比较一直到未排序的最后一个
			for (int j = 1; j <len - i; j++) {
				if(array[j] < array[j-1])
				{
					changeItem(array,i,j-1);
				}
			}
		}
	}



}
