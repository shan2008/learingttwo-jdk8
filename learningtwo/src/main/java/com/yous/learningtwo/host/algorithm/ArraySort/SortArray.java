package com.yous.learningtwo.host.algorithm.ArraySort;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class SortArray {


    /**
     * 选择排序法
     * 每次排出最小第一个与第一个交换
     */
    public void selectSort(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }


    /**
     * 冒泡排序法
     *
     * @param array
     */
    public void bubSort(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return;
    }


    /**
     * 插入排序法
     *
     * @param array
     */
    public void insertSort(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 1; i < array.length; i++) {   // 从第二个元素开始遍历
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {     // 将当前元素移动到合适的位置
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }

    }


    /**
     * 快速排序法
     *
     * @param array
     * @param low
     * @param high
     */
    public void quickSort(int[] array, int low, int high) {
        if (array == null) {
            return;
        }

        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int target = array[low];
        while (i < j) {
            // 右边找一个比基准值小的
            while (i < j && array[j] >= target)
                j--;

            if (i < j) {
                array[i++] = array[j];
            }

            // 左边找一个比基准值大的
            while (i < j && array[i] <= target)
                i++;

            if (i < j) {
                array[j--] = array[i];
            }
        }

        array[i] = target;
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);

    }

}
