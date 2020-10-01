package com.lzh.dayDayUp.sort;

public class QuickSort {

    //定义全局变量
    int a[] = {3, 1, 6, 7, 2, 8, 9, 10, 4, 5};
    int length = a.length;

    void quickSort(int left, int right) {
        int i, j, pivot;

        if (left > right) {
            return;
        }

        //pivot中存的就是基准值
        pivot = a[left];

        i = left;
        j = right;

        while (i != j) {
            //顺序很重要，要先从右边开始找 

            //原因：从右往左，a[j]的值比基准值大的，则j一直左移，直到遇到比基准值小的停下，然后a[i]从左往右遇到比基准值大的停下，交换数值，倒数第二次交换完
            //每次从右往左开始找，j停在了比基准值小的数的位置上，与i相遇，将这个值与基准值交换，符合条件
            //要是从左往右开始找，当i停在了比基准值大的位置上,与j相遇，将这个值与基准值交换的话，就不符合条件了，
            //也可能会出现i=j,且a[i]与a[j]的值都比基准值大

            while (a[j] >= pivot && i < j) {
                j--;
            }

            //再找左边的 
            while (a[i] <= pivot && i < j) {
                i++;
            }

            //交换两个数在数组中的位置 
            if (i < j) {
                //用按位异或不用开辟新的空间
                a[i] ^= a[j];
                a[j] ^= a[i];
                a[i] ^= a[j];
            }
        }

        //最终将基准值归位 
        a[left] = a[i];//i与j相遇后的值给a[left]
        a[i] = pivot;//将基准值放在i与j相遇的位置

        quickSort(left, i - 1);//递归处理左边的 
        quickSort(i + 1, right);//递归处理右边的 

    }

    private void start() {
        //快速排序调用 
        quickSort(0, length - 1);


        //输出排序后的结果 
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("pause");

    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        qs.start();


    }
}
