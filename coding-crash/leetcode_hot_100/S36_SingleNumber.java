package leetcode_hot_100;

public class S36_SingleNumber {
    /*
    https://leetcode.cn/problems/single-number/
    线性时间、参数空间来解决这个问题只能用位运算来解决（异或）
     */

    private int findTheSingleNumber(int[] arr){
        int mark = 0;

        for (int i : arr) {
            mark ^= i;
        }

        return mark;
    }

    public static void main(String[] args) {
        System.out.println(new S36_SingleNumber().findTheSingleNumber(new int[]{1,3,2,3,2}));
    }
}
