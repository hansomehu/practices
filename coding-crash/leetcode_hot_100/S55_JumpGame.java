package leetcode_hot_100;

public class S55_JumpGame {
    /*
    https://leetcode.cn/problems/jump-game/solutions/

    设想一下，对于数组中的任意一个位置 yyy，我们如何判断它是否可以到达？
    根据题目的描述，只要存在一个位置 xxx，它本身可以到达，并且它跳跃的最大长度为 x+nums[x]，
    这个值大于等于 y，即 x+nums[x]≥y ，那么位置 y 也可以到达。

    解决思路很简单，就是遍历：
    1、从首元素开始往前跳max距离
    2、从max距离的元素开始往后退，在区间中判断是否存在元素能直接跳到尾元素
     */
    private boolean jump(int[] places) {
        int n = places.length;
        int mostRight = 0;

        for (int i = 0; i < n; i++) {
            int nextMostRight = i + places[i];

            while (nextMostRight > i) {
                mostRight = Math.max(mostRight, nextMostRight);

                if (mostRight > n) return true;

                nextMostRight--;
            }
        }

        return false;
    }
}
