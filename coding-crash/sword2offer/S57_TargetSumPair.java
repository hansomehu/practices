package sword2offer;

public class S57_TargetSumPair {
    /*
    https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
    和为s的两个数字，一个升序的数组
    使用对撞双指针，从两端开始遍历，这样的time cost 为 O（1）
     */
    private int[] sum(int[] nums, int target){
        int r = nums.length, l = 0;
        int[] res = new int[2];

        while (r >= l){
            if ((nums[l] + nums[r]) > target){
                r--;
            } else if ((nums[l] + nums[r]) < target){
                l++;
            } else {
                res[0] = nums[l];
                res[1] = nums[r];
            }
        }

        return res;
    }
}
