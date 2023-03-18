package classified.dp;

public class S46_TranslateNum2String {

    /*
    https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
    非常entry level的dp问题
    结合着青蛙跳台阶一起看看这种简单解法
     */
    private int translateNum(int num){
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length + 1]; // 放大一个以消除边界隐患
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= chars.length; i++) {
            int n = (chars[i-2] - '0') * 10 + (chars[i-1] - '0');
            if (n >= 10 && n <= 25){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }

        return dp[chars.length];

    }
}
