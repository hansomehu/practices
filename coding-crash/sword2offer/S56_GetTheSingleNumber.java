package sword2offer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class S56_GetTheSingleNumber {

    /**
     * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
     * 数组中数字出现的次数
     *
     * 要求空间复杂度O（1）只能位运算；O（N）的话这可以采用常规的哈希表
     */

    public int[] solution(int[] nums){

        int flag = 0;
        for (int num : nums) {
            flag ^= num;
        }

        int m = 1;
        while ((m & flag) == 0) m <<= 1;

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }

        return new int[]{x,y};
    }


    /**
     * V2 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
     */
    public int solution_2(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num, 1);
            }else map.put(num, map.get(num)+1);
        }

        AtomicInteger res = new AtomicInteger();
        map.forEach((k,v) -> {
            if (v == 3) res.set(k);
                }
        );

        return res.intValue();
    }
}
