package com.victormeng.leetcode.sort_algorithm;

import java.util.Random;

public class QuickSort {
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mark = arr[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= mark) {
                swap(arr, ++index, i);
            }
        }
        swap(arr, index, start);
        quickSort(arr, 0, index - 1);
        quickSort(arr, index + 1, end);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(20);
        }
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
