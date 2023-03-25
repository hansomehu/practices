package classified.dp;

public class LongestCommonSubStr {
    /*
    https://leetcode.cn/problems/longest-common-subsequence/

    二维dp问题，dp[m][n]表示两个字符串分别在0-m/0-n的范围内的lcs的长度
    转移方程是明朗的：
    当i、j处的字符相等时 ----> f[i][j]=f[i−1][j−1]+1
    当不相等时 ----> 各退一位找曾经最长的长度 max(f[i-1][j], f[i][j-1])
     */
    private int lcs(String str1, String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            char cur1 = str1.charAt(i - 1);

            for (int j = 1; j <= l2; j++) {
                char cur2 = str2.charAt(j - 1);

                if (cur1 == cur2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[l1][l2];
    }
}
