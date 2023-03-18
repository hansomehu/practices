package classified.string;

import java.util.HashMap;
import java.util.Map;

public class S48_LongestSubStrWithoutRepeatChar {

    /**
     * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
     * 最长不含重复字符的子字符串
     *
     * 1. 暴力解法
     * 2. dp
     */

    public int solution_dp(String s){
        Map<Character, Integer> hp = new HashMap<>();

        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++){
            if (hp.containsKey(s.charAt(j))){
                i = Math.max(i, hp.get(s.charAt(j)));
            }
            hp.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }

        return res;
    }
}
