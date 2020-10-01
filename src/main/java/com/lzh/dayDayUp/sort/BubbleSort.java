package com.lzh.dayDayUp.sort;

import java.util.Arrays;

//@SpringBootApplication
public class BubbleSort {
    private void bubbleSort(int array[]){
        int temp;
        for (int i=0;i<array.length-1;i++){
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
//        SpringApplication.run(BubbleSort.class, args);
        int[] array = {90,14,21,3,51,6,2};
        BubbleSort bubbleSort=new BubbleSort();
        bubbleSort.bubbleSort(array);
    }
}
