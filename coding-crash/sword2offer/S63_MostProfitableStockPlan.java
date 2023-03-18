package sword2offer;

public class S63_MostProfitableStockPlan {

    /**
     * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/description/
     *
     * 用动态规划，相当于计算每一段前低后高的点之间的差值，返回差值最大的那个
     */

    public int solution(int[] prices){

        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            // lowest price
            cost = Math.min(cost, price);
            // biggest profit
            profit = Math.max(profit, price - cost);
        }

        return profit;
    }
}
