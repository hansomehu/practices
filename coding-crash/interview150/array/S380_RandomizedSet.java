package interview150.array;

import java.util.*;

public class S380_RandomizedSet {
    /*
    https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&id=top-interview-150
    在常数时间完成插入、删除和获取随机元素的操作
    解决方案是引入一个HashSet：
    1、在hashSet中维护每个元素的index映射
    2、删除时用数组尾部元素做替换，然后删除队尾元素，这样就不用走O（n）来进行规整
    3、插入时放在数组末尾，然后在hashSet中新建一个映射
     */
    List<Integer> nums;
    Map<Integer, Integer> indices;

    public S380_RandomizedSet() {
        this.nums = new ArrayList<>();
        this.indices = new HashMap<>();
    }

    // insert
    public boolean insert(int num){
        if (indices.containsKey(num)) return false;
        nums.add(num);
        indices.put(num, nums.size() - 1);

        return true;
    }

    // remove
    public boolean remove(int num){
        if (!indices.containsKey(num)) return false;

        Integer index = indices.get(num);
        nums.set(index, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);

        return true;
    }

    // get random
    public int getRandom(){
        return nums.get(new Random().nextInt(nums.size()));
    }
}
