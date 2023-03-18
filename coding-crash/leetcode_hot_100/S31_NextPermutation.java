package leetcode_hot_100;

public class S31_NextPermutation {
    /*
    https://leetcode.cn/problems/next-permutation/solutions/
    找到数组的下一个字典序排列
    找规律题

    1. 从后向前 查找第一个 相邻升序 的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
    2. 在 [j,end) 从后向前 查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
    3. 将 A[i] 与 A[k] 交换
    4. 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
    如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     */

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private int[] solution(int[] nums){
        int len = nums.length, i = len, j = len;

        // 1
        while ( i >= 1 ){
            if (nums[i] > nums[i-1]) break;
            i--;
        }

        // 2
        while ( j >= i){
            if (nums[i-1] < nums[j]) {
                swap(nums, i-1, j); // 3
                break;
            }
            j--;
        }

        reverse(nums, j); // 4

        return nums;
    }


}
