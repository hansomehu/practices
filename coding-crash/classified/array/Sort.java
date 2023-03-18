package classified.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sort {
    /*
    基本功，数组排序
     */
    public void swap(int[] arr, int i, int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // bubble sort
    public int[] solution_bubble_sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) { // 只需要n-1轮交换
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) swap(arr, j, j+1);
            }

        }

        return arr;
    }

    // quick sort
    public int[] solution_quick_sort(int[] arr){
        quickSort(arr, 0, arr.length-1);

        return arr;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r){
            // divide the arr
            int point = partition(arr, l, r);
            quickSort(arr, l , point - 1);
            quickSort(arr, point + 1, r);
        }

    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l < r){
            while (l < r && arr[r] >= pivot){
                r--;
            }
            swap(arr, l, r);

            while (l < r && arr[l] <= pivot){
                l++;
            }
            swap(arr, l , r);
        }

        return l; // the position of pivot
    }

    // priority queue
    public int[] solution_pq(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }
        );

        return null;
    }

    // merge and sort two arrays
    public int[] solution_median(int[] arr1, int[] arr2){
        int l1 = arr1.length;
        int l2 = arr2.length;

        int[] res = new int[l1 + l2];

        int a1 = 0, a2 = 0;
        while ((a1 <= l1 -1) || (a2 <= l2 - 1)){
            int res_pos = 0;
            if (arr1[a1] >= arr2[a2]){
                res[res_pos] = arr2[a2];
                a2++;
            }else {
                res[res_pos] = arr1[a1];
                a1++;
            }
            res_pos++;
        }

        return res;
    }
}
