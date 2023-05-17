package interview150.array;

public class S45_JumpGame2 {
    /*
    https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&id=top-interview-150
    解法就是从前往后进行遍历，采用贪心算法在一跳的范围内选取最远距离来当作是下一跳的距离
     */
    private int solution(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        int steps = 0;
        int range = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);

            if (i == range) {
                range = maxPosition;
                steps++;
            }
        }

        return steps;
    }
}
