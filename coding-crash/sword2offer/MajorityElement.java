package sword2offer;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solutions/
 */
public class MajorityElement {

    public int solution(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
