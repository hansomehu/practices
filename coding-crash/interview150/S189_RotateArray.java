package interview150;

public class S189_RotateArray {
    /*
    https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&id=top-interview-150
    要点在于遍历的元素总数量为n，k的最大公约数
     */
    private void solution(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);

        for (int start = 0; start < count; start++) {
            int cur = start;
            int prev = nums[start];

            do {
                int next = (cur + k) % n; // 该数在rotate后的位置
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
            } while (start != cur);
        }
    }

    // gcd算法记住
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
