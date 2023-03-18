package classified.dp;

import java.util.HashMap;
import java.util.Map;

public class S48_LongestSubStrWithoutRepeatChar {

    /**
     * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
     * 最长不含重复字符的子字符串
     * 转移方程是 f(dp[j]) = Max(f(dp[j-1]), j - mostRecentRepeatIndex)
     *
     * 1. 暴力解法
     * 2. dp
     */

    public int solution_dp(String s){
        Map<Character, Integer> hp = new HashMap<>();

        int i = -1, res = 0; // i是当前重复字符上一次出现的坐标
        for (int j = 0; j < s.length(); j++){
            if (hp.containsKey(s.charAt(j))){
                i = Math.max(i, hp.get(s.charAt(j)));
            }
            hp.put(s.charAt(j), j);
            res = Math.max(res, j - i); // 当前坐标减去最近重复字符的坐标
        }

        return res;
    }
}
