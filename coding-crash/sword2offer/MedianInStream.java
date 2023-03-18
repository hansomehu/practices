package sword2offer;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
public class MedianInStream {

    // 优先级高的先出
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public void MedianFinder(){

        // 如果认为a比b的优先级高，lambda返回>0的数，否则返回<0的数，返回0这是认为优先级相同
        queMin = new PriorityQueue<>((a, b) -> (b - a));
        queMax = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num){
        if (queMin.isEmpty() || num <= queMin.peek()){
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()){
                queMax.offer(queMin.poll());
            }
        }else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()){
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian(){
        if (queMin.size() > queMax.size()){
            return queMin.peek();
        }

        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
