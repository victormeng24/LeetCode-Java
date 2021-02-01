package com.victormeng.leetcode.sort_algorithm;

public class HeapSort {
    public void heapsort(int[] a) {
        int length = a.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            sink(a, i, length - 1);
        }
        int n = length - 1;
        while (n > 0) {
            swap(a, n--, 0);
            sink(a, 0, n);
        }
    }

    public void sink(int[] a, int k, int n) {

        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j < n && a[j] < a[j + 1])
                j++;
            if (a[k] > a[j]) break;
            swap(a, j, k);
            k = j;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
