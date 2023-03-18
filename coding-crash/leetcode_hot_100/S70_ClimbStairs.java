package leetcode_hot_100;

public class S70_ClimbStairs {
    /*
    https://leetcode.cn/problems/climbing-stairs/solutions/
    这是一道极为经典的母题，"数字转字母"
    动态规划最简单的母题
    用滚动数组可以完成空间复杂度上的优化
     */
    private int solution(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[n] = dp[n-1] + dp[n-2];
        }

        return dp[n];
    }

    // space optimization
    private int solution2(int n){
        int first = 1;
        int second = 2;

        for (int i = 3; i <= n ; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
