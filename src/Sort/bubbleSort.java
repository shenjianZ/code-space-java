package Sort;

import java.util.Arrays;

public class bubbleSort {
    /**
     * method :未优化的冒泡排序
     * description : 外层循环N轮，内层循环N轮,时间复杂度为O(n^2)
     * N遍外层循环，N遍内层循环，为O(n^2)
     * Sorting stability :排序稳定性，是稳定的，大小相同的两个元素在排序之前和排序之后的先后顺序没有改变
     *
     * @param arr，需要排序的数组
     */
    public static void bubbleSort_01(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * method :优化的冒泡排序
     * description : 外层循环N-1轮，内层循环N-1轮,时间复杂度为O(n)~O(n^2)
     * 最好的情况是一遍外层循环,N-1遍内层循环,为O(n)，当isSorted为true，直接结束内外循环
     * 最坏的情况是N-1遍外层循环，N-1遍内层循环，为O(n^2)
     * Optimization : 排序的优化点 :
     * 外层、内层循环由N轮变为N-1轮，设置isSorted变量，判断未排序部分是否有序
     * Sorting stability : 排序稳定性，是稳定的，大小相同的两个元素在排序之前和排序之后的先后顺序没有改变
     *
     * @param arr，需要排序的数组
     */
    public static void bubbleSort_02(int[] arr) {
        //注意此处i < arr.length-1，外层循环N-1轮
        for (int i = 0; i < arr.length - 1; i++) {
            //将 isSorted 置true，表示未排序部分是有序的，无需排序
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //将 isSorted 置false，表示未排序部分存在无序，仍需排序
                    isSorted = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (isSorted) return; //如果没有发生任何交换，isSorted一定是true，数组已经有序，直接退出
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 8, 3, 2, 1, 9, 4, 7, 6};
        int[] arr2 = {5, 8, 3, 2, 1, 9, 4, 7, 6};

        //得到arr1排序的所用时间
        long startTime1 = System.nanoTime();
        bubbleSort_01(arr1);
        long endTime1 = System.nanoTime();
        System.out.println("排序arr1所用时间：" + (Float.parseFloat(String.valueOf(endTime1 - startTime1)) / 1000000) + "ms");
        long startTime2 = System.nanoTime();
        bubbleSort_02(arr1);
        long endTime2 = System.nanoTime();
        System.out.println("排序arr2所用时间：" + (Float.parseFloat(String.valueOf(endTime2 - startTime2)) / 1000000) + "ms");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

}
