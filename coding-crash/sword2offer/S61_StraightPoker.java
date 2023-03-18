package sword2offer;

import java.util.HashSet;

public class S61_StraightPoker {
    /*
    https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
    扑克牌中的顺子
     */
    private boolean solution(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int min = 0, max = 14;

        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) return false;
            set.add(num);
        }

        return max - min < 5; // 最重要的规律就在这里，如果五张牌不重复且差值小于5的话这必然straight
    }
}
