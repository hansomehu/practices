package sword2offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class S59_MaxValueInTheQueue {

    /**
     * 队列的最大值
     * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/description/
     * 要求在 O (1) 的时间内完成 max_value 操作
     * 采用辅助数据结构deque来配合queue进行最大数的存储，以达到时间要求
     */


    Queue<Integer> q = new LinkedList<>();
    Deque<Integer> d = new LinkedList<>();

    public int max_value(){
        if (d.isEmpty()) return -1;

        return d.peekFirst();

    }

    public void push_back(int value){
        while (!d.isEmpty() && d.peekLast() < value){
            d.pollLast();
        }

        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front(){
        if (q.isEmpty()) return -1;

        int res = q.poll();
        if (res == d.peekFirst()){
            d.pollFirst();
        }

        return res;
    }
}
