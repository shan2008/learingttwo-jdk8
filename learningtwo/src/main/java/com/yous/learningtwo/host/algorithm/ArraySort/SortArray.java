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

    }

}
