package sword2offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequence {

    public boolean validate(int[] pushed, int[] popped){
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
