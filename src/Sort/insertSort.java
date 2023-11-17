package Sort;

import java.util.Arrays;

public class insertSort {

    /**
     * method :未优化的直接插入排序
     * description : 时间复杂度为O(n)~O(n^2)
     * 当数组本身是完全有序的，内层while循环未执行，只有外层N轮for循环，为O(n)
     * 当数组本身是完全无序的，内层while循环吃满，内存while也执行，为O(n^2)
     * Sorting stability :排序稳定性，是稳定的，大小相同的两个元素在排序之前和排序之后的先后顺序没有改变
     *
     * @param arr，需要排序的数组
     */
    public static void insertSort_01(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * method :优化的直接插入排序
     * description : 时间复杂度为O(n)~O(n^2)
     * <p>
     * Sorting stability :排序稳定性，是不稳定的，二分搜索返回的插入位置在元素相同时，会使得数组中相同元素的先后次序改变
     *
     * @param arr，需要排序的数组 }
     */
    public static void insertSort_02(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = binarySearch(arr, 0, i - 1, key);//返回的j是要插入的位置
            for (int k = i; k > j; k--)
                arr[k] = arr[k - 1];
            arr[j] = key;
        }
    }


    /**
     * method :二分搜索
     *
     * @param arr    需要排序的数组
     * @param left   左边界
     * @param right  右边界
     * @param target 目标元素
     * @return 目标元素的后一位，即插入位置
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target < arr[mid])
                right = mid - 1;
            else if (target > arr[mid])
                left = mid + 1;
            else if (target == arr[mid])
                return mid + 1;//返回的是目标元素的后一位，即插入位置
        }
        return left; //直接返回左侧
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 8, 3, 2, 1, 9, 4, 7, 6};
        int[] arr2 = {5, 8, 3, 2, 1, 9, 4, 7, 6};

        //得到arr1排序的所用时间
        long startTime1 = System.nanoTime();
        insertSort_01(arr1);
        long endTime1 = System.nanoTime();
        System.out.println("排序arr1所用时间：" + (Float.parseFloat(String.valueOf(endTime1 - startTime1)) / 1000000) + "ms");
        long startTime2 = System.nanoTime();
        insertSort_02(arr1);
        long endTime2 = System.nanoTime();
        System.out.println("排序arr2所用时间：" + (Float.parseFloat(String.valueOf(endTime2 - startTime2)) / 1000000) + "ms");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}