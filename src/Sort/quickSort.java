package Sort;

import java.util.Arrays;

public class quickSort {
    /**
     * method :未优化的快速排序
     * description : 通过与基准值pivot的比较，基准值左右两侧完成排序，
     * pivot两侧继续进行快速排序
     * Sorting stability :排序稳定性，是不稳定的,交换元素时，相同元素的顺序可能会改变
     *
     * @param arr 排序数组
     */
    public static void quickSort_01(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start, right = end, pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;//基准值的位置
        quickSort_01(arr, 0, left - 1);
        quickSort_01(arr, left + 1, end);
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 8, 3, 2, 1, 9, 4, 7, 6};
        int[] arr2 = {5, 8, 3, 2, 1, 9, 4, 7, 6};

        long startTime1 = System.nanoTime();
        quickSort_01(arr1, 0, arr1.length - 1);
        long endTime1 = System.nanoTime();
        System.out.println("排序arr1所用时间：" + (Float.parseFloat(String.valueOf(endTime1 - startTime1)) / 1000000) + "ms");
//        long startTime2 = System.nanoTime();
//        selectSort_02(arr1);
//        long endTime2 = System.nanoTime();
//        System.out.println("排序arr2所用时间："+(endTime2-startTime2)+"ms");
        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));

    }
}
