package org.buptdavid.datastructure.sort;

/**
 * 选择排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 * @author weijielu
 * @see ISort
 * @see SortTest
 */
public class SelectionSort implements ISort {

	@Override
    public void sort(int[] array) {
		sort1(array);
	}

	private void sort1(int[] array)
	{
		int temp = 0;
		for(int i = 0; i < array.length; i++){
			temp = array[i];
			for(int j = i; j < array.length; j++){
				if(temp > array[j]){
					temp = array[j];
				}
			}

			if(temp != array[i]){
				array[i] = temp;
			}
		}
	}
	private void sort2(int[] array)
	{
		int len = array.length;
		for (int i = 0; i < len; i++) {
			//当前循环中最小的一个值的下标
			int index = i;
			for (int j = i+1; j <len ; j++) {
				//判断当前位置是否最小的值
				if (array[j]<array[index])
				{
					index = j;
				}
			}
			//交换开始位置值和最小值
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;

		}
	}



}
