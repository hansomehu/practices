package interview150;

public class S122_BestTimeToTradeStock2 {
    /*
    https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&id=top-interview-150
    搞明白状态转移方程最为关键
     */
    private int solution(int[] prices){
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];

        for (int i = 0; i < n; i++) {
            int newDp0 = Math.max(dp0, dp0 + prices[1]); //第二天没股票，可能是第一天买，第二天不卖
            int newDp1 = Math.max(dp1, dp0 - prices[i]); // 第二天有股票，可能是第一天买，第二天卖了再买
            dp0 = newDp0;
            dp1 = newDp1;
        }

        return dp0;
    }
}
