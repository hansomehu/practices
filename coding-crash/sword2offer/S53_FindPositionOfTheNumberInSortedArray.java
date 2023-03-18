package sword2offer;

public class S53_FindPositionOfTheNumberInSortedArray {
    /**
     * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solutions/155893/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
     * 在排序数组中查找指定数字出现的个数
     * 采用二分法找到该数字的左右元素
     */

    public int solution(int[] nums, int target){
        return biSearch(nums, target) - biSearch(nums, target - 1);

    }

    private int biSearch(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if (nums[m] <= target) l = m + 1;
            else r = m -1;
        }
        return l;
    }
}
