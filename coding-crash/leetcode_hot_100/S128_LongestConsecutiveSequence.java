package leetcode_hot_100;

import java.util.HashSet;

public class S128_LongestConsecutiveSequence {
    /*
    https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&id=top-100-liked
    最长连续序列
    使用set逐个遍历判断，例如从x开始，我们判断是否存在x+1，如果存在则判断是否存在x+1+1 ... 以此类推
    出于时间复杂度考虑，我们不能进行完全的遍历，
    也就是不加思索地一个增强for循环遍历完所有的元素，
    而需要考虑什么元素是不需要遍历的（明显不是连续的数）
     */
    private int longestStreak(int[] nums){
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer e : set) {
            if (!set.contains(e)){ // 如果前一个数存在那么必然可以跳过这个数，当遍历到value = e-1 再进行匹配，这样符合取最大值的逻辑
                int curNum = e;
                int curRes = 0;

                while (set.contains(e+1)){
                    curNum = e + 1;
                    curRes+=1;
                }

                res = Math.max(res, curRes);
            }
        }

        return res;
    }
}
