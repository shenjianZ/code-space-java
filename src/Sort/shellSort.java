package Sort;

import java.util.Arrays;

public class shellSort {


    /**
     * method: 希尔排序
     * description:希尔排序又叫缩小增量排序，是直接插入排序的进阶，对数组按步长分组，
     * 来进行同一组内的插入排序，直到最后进行一次完整的直接插入排序
     *
     * @param arr 排序数组
     */
    public static void shellSort_01(int[] arr) {
        int delta = arr.length;
        while (delta >= 1) {
            for (int i = delta; i < arr.length; i++) {
                int key = arr[i];
                int j = i - delta;
                while (j >= 0 && arr[j] > key) {
                    arr[j + delta] = arr[j];
                    j -= delta;
                }
                arr[j + delta] = key;
            }
            delta /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 8, 3, 2, 1, 9, 4, 7, 6};

        //得到arr1排序的所用时间
        long startTime1 = System.nanoTime();
        shellSort_01(arr1);
        long endTime1 = System.nanoTime();
        System.out.println("排序arr1所用时间：" + (Float.parseFloat(String.valueOf(endTime1 - startTime1)) / 1000000) + "ms");
        System.out.println(Arrays.toString(arr1));
    }
}
