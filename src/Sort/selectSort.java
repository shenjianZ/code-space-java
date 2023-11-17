package Sort;


import java.util.Arrays;

public class selectSort {

    /**
     * method :未优化的直接选择排序
     * description : 时间复杂度为O(n^2)
     * 无论如何，都会进行N层内外循环，为O(n^2)
     * Sorting stability :排序稳定性，是不稳定的，寻找最小元素的索引时，会使得数组中相同元素的先后次序改变
     *
     * @param arr 排序数组
     */
    public static void selectSort_01(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    /**
     * method :优化的直接选择排序
     * description : 时间复杂度为O(n^2)
     * 无论如何，都会进行内外循环，只不过效率高了一倍，为O(n^2)
     * Sorting stability :排序稳定性，是不稳定的，寻找最小元素的索引时，会使得数组中相同元素的先后次序改变
     *
     * @param arr 排序数组
     */
    public static void selectSort_02(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int min = left, max = right;
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[min]) min = i;
                if (arr[i] > arr[max]) max = i;
            }
            int tmp = arr[max];
            arr[max] = arr[right];
            arr[right] = tmp;
            if (min == right) min = max;
            tmp = arr[min];
            arr[min] = arr[left];
            arr[left] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 8, 3, 2, 1, 9, 4, 7, 6};
        int[] arr2 = {5, 8, 3, 2, 1, 9, 4, 7, 6};

        //得到arr1排序的所用时间
        long startTime1 = System.nanoTime();
        selectSort_01(arr1);
        long endTime1 = System.nanoTime();
        System.out.println("排序arr1所用时间：" + (Float.parseFloat(String.valueOf(endTime1 - startTime1)) / 1000000) + "ms");
        long startTime2 = System.nanoTime();
        selectSort_02(arr2);
        long endTime2 = System.nanoTime();
        System.out.println("排序arr2所用时间：" + (Float.parseFloat(String.valueOf(endTime2 - startTime2)) / 1000000) + "ms");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
