package interview150.interval;

import java.util.ArrayList;
import java.util.List;

public class S57_InsertInterval {
    /*
    https://leetcode.cn/problems/insert-interval/
     */
    public List<int[]> solution(List<int[]> intervals, int[] pendingInterval){

        List<int[]> res = new ArrayList<>();
        int L = pendingInterval[0];
        int R = pendingInterval[1];
        boolean placed = false;

        for (int[] interval : intervals) {
            if (interval[0] > R){
                if (!placed) { // the pendingInterval will only be insert once
                    res.add(pendingInterval);  // and is control by this var
                }
                res.add(interval);
            } else if (interval[1] < L){
                res.add(interval);
            } else { // intertwined, update L and R
                L = Math.min(L, interval[0]);
                R = Math.max(R, interval[1]);
            }
        }

        if (!placed) { // the pending one is the furthest interval
            res.add(pendingInterval);
        }

        return res;
    }
}
