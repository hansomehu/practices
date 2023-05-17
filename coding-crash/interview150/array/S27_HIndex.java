package interview150.array;

public class S27_HIndex {
    /*
    https://leetcode.cn/problems/h-index/solutions/?envType=study-plan-v2&id=top-interview-150
     */
    private int solution(int[] citations){
        int n = citations.length;
        int[] cnt = new int[n+1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                cnt[n]++; // H指数的值不超过文章总数
            } else {
                cnt[citations[i]]++;
            }
        }

        int total = 0;
        for (int i = n; i > 0 ; i--) {
            total += cnt[i];

            if (total >= i) return i;
        }

        return 0;
    }
}
