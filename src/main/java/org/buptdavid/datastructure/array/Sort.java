package org.buptdavid.datastructure.array;

public class Sort {

    public int[] marge(int[] arr1,int[] arr2)
    {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int arr[] = new int[len1 + len2];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i<len1 && j<len2)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k++] = arr1[i++];
            }else
                {
                    arr[k++] = arr2[j++];
                }
        }
        //arr1全部小于arr2
        while (i<len1) {
            arr[k++] = arr1[i++];
        }
        while (j<len2)
        {
            arr[k++] = arr2[j++];
        }
        return arr;

    }

    //将有顺序的两个数组合并
    public void marge(int arr[],int start,int mid,int end)
    {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid;
        int k = 0;
        //从第一个开始比较取最小的
        while (i<mid&&j<end)
        {
             if (arr[i]<=arr[j])
            {
                temp[k++] = arr[i++];
            }else
                {
                    temp[k++] = arr[j++];
                }
        }
        //把剩余的排进去
        while (i< mid)
        {
            temp[k++] = arr[i++];
        }
        while (j<end)
        {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < k; l++) {
            arr[start+l] = temp[l];
        }
    }

    public void margeTest()
    {
        int a[] = {1,2,3,2,3,4};
        marge(a,0,3,6);
        int b[] = {1,2,3};
        int c[] = {4,5,6};
        int arr[] = marge(b,c);
    }

    public void margeSortUp2Down(int arr[],int start,int end)
    {
        if(arr==null||start>=end)
        {
            return;
        }

        int mid = (end + start)/2;
        margeSortUp2Down(arr,start,mid);
        margeSortUp2Down(arr,mid+1,end);
        marge(arr,start,mid,end);

    }





    public int[] margeSort(int[] arr)
    {
        int len = arr.length;
        int moddle = len/2;
        if (len == 2)
        {
            int temp[] = new int[2];
            if(arr[0]>arr[1])
            {
                temp[0] = arr[1];
                temp[1] = arr[0];
            }else {
                temp[0] = arr[0];
                temp[1] = arr[1];
            }
            return temp;
        }
        if(len == 1){
            int temp[] = new int[1];
            temp[0] = arr[0];
            return temp;
        }
        int k = 0;
        int[] left = new int[moddle];
        for (int i = 0; i < moddle; i++) {
            left[i] = arr[k++];
        }
        int[] right = new int[len-moddle];
        for (int i = 0; i < len-moddle; i++) {
            right[i] = arr[k++];
        }
        int[] leftresult = margeSort(left);
        int[] rightresult = margeSort(right);
       ;
        return  marge(leftresult,rightresult);
    }






}
