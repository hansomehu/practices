package sword2offer;

import java.util.ArrayDeque;

public class S07_MakeAQueueOutOfStacks {
    /**
     *  Mocking a queue structure with 2 stacks
     *  If we push an element into the queue, we push them into stack1
     *  When it comes to pop an element out of the queue, we
     *  1. pop all the elements into stack2
     *  2. pop the first element in stack2 and return it
     *  3. pop all the remained elements back into stack1
     *  Anyway there is a stack always be empty
     */

    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> stack2 = new ArrayDeque<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        for (int i = 0; i < stack1.size(); i++) {
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        for (int i = 0; i < stack2.size(); i++) {
            stack1.push(stack2.pop());
        }

        return res;
    }


}
