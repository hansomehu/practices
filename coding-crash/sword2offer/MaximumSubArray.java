package sword2offer;

/**
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaximumSubArray {

    public int sum(int[] nums){
        int pre = 0, maxRes = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, pre);
            maxRes = Math.max(maxRes, pre);

        }

        return maxRes;
    }
}
