package org.buptdavid.datastructure.sort;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 排序测试
 * @author weijielu
 * @see ISort
 * @see BubbleSort
 * @see SelectionSort
 * @see MergeSort
 * @see QuickSort
 */
public class SortTest {
	int[] array = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	ISort sort;

	public int[] initData(int len)
	{
		int[] array  = new int[len];
		for (int i = 0; i < array.length; i++) {
			array[i] = new Integer( Math.round(Math.random() * 100)  + "");
		}
		return array;
	}

	public void pringArray(int[] array)
	{
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "   " );
		}
		System.out.println();
	}

	@Before
	public void before(){
		array = initData(10);
		pringArray(array);
	}
	@Test
	public void testChangeItem()
	{
		sort = new BubbleSort();
		sort.changeItem(array,0,1);
	}

	@Test
	public void testBubbleSort(){
		sort = new BubbleSort();
		sort.sort(array);
		validate();
	}
	
	@Test
	public void testSelectionSort(){
		sort = new SelectionSort();
		sort.sort(array);
		validate();
	}
	
	@Test
	public void testMergeSort(){
		sort = new MergeSort();
		sort.sort(array);
		validate();
		
	}
	
	@Test
	public void testQuickSort(){
		sort = new QuickSort();
		sort.sort(array);
		validate();
	}
	
	@Test
	public void testInsertSort(){
		sort = new InsertSort();
		sort.sort(array);
		validate();
	}
	
	@Test
	public void testInsertOptimizeSort(){
		sort = new InsertOptimizeSort();
		sort.sort(array);
		validate();
	}
	
	private void validate(){
		for(int i = 0; i < array.length - 1; i++){
			Assert.assertTrue(array[i] <= array[i + 1]);
		}
	}

	@After
	public void after()
	{
		pringArray(array);
	}

}
