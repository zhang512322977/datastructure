/**
 * 
 */
package org.buptdavid.datastructure.sort;

/**
 * 插入排序实现
 * @author weijielu
 *
 */
public class InsertSort implements ISort {

	public int type = 0;
	public InsertSort(int type)
	{
		this.type = type;
	}
	public InsertSort(){}
	@Override
	public void sort(int[] array) {
		if(type  == 2)
		{
			sort2(array);
		}else
			{
				sort1(array);
			}

	}

	/**
	 * 原作者的插入排序
	 * @param array
	 */
	private void sort1(int[] array)
	{
		for(int i = 1; i < array.length; i++){
			//获取第i个元素 i---> 1-n
			int temp = array[i];
			//获取第i个的上一个的下标
			int j = i - 1;
			//当前元素前面的元素小就前移---会空一个
			while(j >= 0 && array[j] > temp){
				array[j + 1] = array[j];
				j--;
			}
			//不前移了就把当前元素插入
			if(j != i - 1){
				array[j + 1] = temp;
			}
		}
	}


	/**
	 *  我的插入排序
	 * @param array
	 */
	private void sort2(int[] array)
	{
		int len = array.length;
		//遍历的次数
		for (int i = 1; i < len; i++) {
			//判断是否比前一个小，是的话就交换
			for (int j = i; j >0; j--) {
				if (array[j]<array[j-1])
				{
					changeItem(array,j,j-1);
				}

			}
		}

	}
}
