package interview150.array;

public class S169_MajorityElement {
    /*
    https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&id=top-interview-150
    使用Boyer-Moore算法
     */
    private int solution(int[] nums){
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
