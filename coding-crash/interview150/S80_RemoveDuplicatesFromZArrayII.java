package interview150;

public class S80_RemoveDuplicatesFromZArrayII {
    /*
    https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&id=top-interview-150
    删除排序数组中的重复项，返回最后的长度，并且最大允许的重复次数为两次
    思路：
    快慢指针，快指针不断往前走并判断后面俩和当前是不是连续重复，如果不重复那慢指针也跟着走一步
    如果重复，那只走快指针不走慢指针，直到快指针当前值不再是连续重复
    最后返回慢指针的坐标，通过慢指针不走这种方式实现了去掉重复个数的操作
     */
    private int solution(int[] nums){
        int fast = 2, slow = 2;

        while (fast < nums.length){
            if (nums[slow - 2] != nums[fast]) { // 如果相等则是第三重复
                nums[slow] = nums[fast]; // 将重复元素覆盖掉，遍历完后取(0,slow)就是符合条件的去重后数组

                slow++;
            }

            fast++;
        }

        return slow;
    }
}
