package leetcode_hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S56_MergeIntervals {
    /*
    https://leetcode.cn/problems/merge-intervals/

    其中的规律点：
    1. 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
    2. 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。

    排序后逐个进行两两合并判断
     */
    private List<int[]> solution(int[][] intervals){
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // small first
            }
        });

        for (int i = 0; i <= intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.isEmpty() || L > res.get(res.size()-1)[1]){ // 当前的左边界大于最大有边界，无法合并
                res.add(intervals[i]);
            } else if (res.get(res.size()-1)[1] < R){
                res.get(res.size()-1)[1] = R;
            }
            // optimization
//            else {
//                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], R);
//            }
        }

        return res;
    }
}
