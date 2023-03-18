package sword2offer;

public class S53_TheMissingNumber {
    /*
    https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
    有序数组的查找问题就是二分
     */
    private int theMissingNum(int[] nums){
        int l = 0, r = nums.length - 1;

        while (r >= l){
            int m = (l + r) / 2;
            if (nums[m] == m){
                l = m + 1;
            }else r = m - 1;
        }

        return l; // 最终的退出条件需要总结得出
    }
}
