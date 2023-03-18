package leetcode_hot_100;

public class S53_MaximumSubArray {
    /*
    https://leetcode.cn/problems/maximum-subarray/description/
    最大连续子数组的和
    最简单的动态规划了，转移方程f(i)=max{f(i−1)+nums[i],nums[i]}
     */
    private int maxSubArr(int[] arr){
        int preOptimal = 0, globalOptimal = arr[0];

        for (int i = 0; i < arr.length; i++) {
            preOptimal = Math.max(preOptimal + arr[i], arr[i]); // 保存每一步中可能的最大值
            globalOptimal = Math.max(preOptimal, globalOptimal); // 永远保存全局最大值
        }

        return globalOptimal;
    }
}
