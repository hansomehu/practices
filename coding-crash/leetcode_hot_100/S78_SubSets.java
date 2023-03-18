package leetcode_hot_100;

import java.util.ArrayList;
import java.util.List;

public class S78_SubSets {
    /*
    https://leetcode.cn/problems/subsets/
    采用"动态线性规划"来解题

    例如[1,2,3]，一开始解集为[[]]，表示只有一个空集。
    遍历到1时，依次拷贝解集中所有子集，只有[]，把1加入拷贝的子集中得到[1]，然后加回解集中。此时解集为[[], [1]]。
    遍历到2时，依次拷贝解集中所有子集，有[], [1]，把2加入拷贝的子集得到[2], [1, 2]，然后加回解集中。此时解集为[[], [1], [2], [1, 2]]。
    遍历到3时，依次拷贝解集中所有子集，有[], [1], [2], [1, 2]，把3加入拷贝的子集得到[3], [1, 3], [2, 3], [1, 2, 3]，然后加回解集中。此时解集为[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]。
     */
    private List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList(){
            {
                add(new ArrayList<>());
            }
        };

        for (int num : nums) {
            for (List<Integer> re : res) {
                List<Integer> tmp1 = re;
                tmp1.add(num);
                res.add(tmp1);
            }
        }

        return res;
    }
}
