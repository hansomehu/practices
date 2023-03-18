package leetcode_hot_100;

public class S96_UniqueBinarySearchTrees {
    /*
    https://leetcode.cn/problems/unique-binary-search-trees/

    找到规律后使用动态规划
     */
    private int find(int[] nums){
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { //最少两个节点构成树
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i-1] * dp[i-2];
            }
        }

        return dp[n];
    }
}
