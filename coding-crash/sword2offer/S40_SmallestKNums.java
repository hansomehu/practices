package sword2offer;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 *
 * 这道题可以延伸出很多类似题，各种的在一个无序数组中招第N大/小的值，解法包括以下三种
 * 1 笔试当中直接sort
 * 2 小顶堆/大根堆 PriorityQueue
 * 3 快速选择算法，快排的变种算法
 */
public class S40_SmallestKNums {

//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//
//        return Arrays.copyOf(arr, k);
//    }

    // 采用快速选择算法 N时间复杂度
    public int[] getLeastNumbers(int[] arr, int k){
        return quickSort(arr, k, 0, arr.length);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
         int i = l, j = r;

         // 快排最快之解法，不用过度考虑pivot，直接最左
         // quick sort, choose the leftest node as pivot
         while(i < j){
             while (i < j && arr[j] >= arr[l]) j--;
             while (i < j && arr[i] <= arr[l]) i++;
             swap(arr, i, j);
         }
         swap(arr, i, l); // move the pivot to the middle

         if (i > k) return quickSort(arr, k, l, i-1);
         if (i < k) return quickSort(arr, k, i+1, r);

         return Arrays.copyOf(arr, k);

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
