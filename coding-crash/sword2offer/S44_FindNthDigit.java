package sword2offer;

public class S44_FindNthDigit {
    /*
    https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
    数字序列中的某一位数，这个属于纯找规律题
     */
    private int solution(int n){
        int digit = 1, start = 1, count = 9;

        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        } // 所在位数的总数字量
        long num = start + (n - 1) / digit; // 所在的数字

        return Long.toString(num).charAt((n-1) % digit) - '0'; // 这就是它的规律点
    }
}
