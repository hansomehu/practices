package interview150.sliding_windown;

public class S209_MinimumSizeSubArray {
    /*
    https://leetcode.cn/problems/minimum-size-subarray-sum/
     */
    public int solution(int[] nums, int target){
        int n = nums.length;

        int head = 0, tail = 0, res = n, sum = 0;
        while (tail < n){
            if (nums[tail] >= target) return 1;
            if (tail == head) continue;

            if (sum < target){
                sum += nums[tail++];
            } else if (sum > target){
                sum -= nums[head++];
            } else {
                res = Math.min(res, tail - head + 1);
            }
        }

        return res;
    }

    // leetcode version
    public int solution2(int[] nums, int target){
        int n = nums.length;

        int head = 0, tail = 0, res = n+1, sum = 0;
        while (tail < n) {
            sum += nums[tail];
            while (sum >= target){
                res = Math.min(res, tail - head + 1);
                sum -= nums[head++];
            }
        }

        return res == n+1 ? 0 : res;
    }

}
