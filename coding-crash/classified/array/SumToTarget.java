package classified.array;

import java.util.ArrayList;
import java.util.List;

public class SumToTarget {
    /*
    https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
    和为s的连续正数列
     */
    public int[][] solution(int target){
        List<int[]> vec = new ArrayList<>();
        for (int l = 1, r = 2; l < r;){
            int sum = (l+r) * (r-l+1) / 2;
            if (sum == target){
                int[] res = new int[r-l+1];
                for (int i = l; i <= r; ++i){
                    res[i - l] = i;
                }
                vec.add(res);
            }else if(sum < target){
                r++;
            }else {
                l++;
            }
        }

        return vec.toArray(new int[vec.size()][]);
    }


    /*
    简单版的题，在一个排序数组中，找到两个数，它们的和为s
     */
    public int[] solution2(int[] arr, int target){
        int r = arr.length - 1;
        int l = 0;
        int[] res = new int[2];

        while (l >= r){
            int sum = arr[r] + arr[l];
            if (sum == target) {

            } else if(sum > target){

            }else {

            }
        }

        return res;
    }
}
