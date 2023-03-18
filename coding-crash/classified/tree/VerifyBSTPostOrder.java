package classified.tree;

import java.util.Stack;

public class VerifyBSTPostOrder {

    /*
        验证BST的后序遍历是否合法（看看是不是一个BST）
     */

    public boolean verify(int[] postorder){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0 ; i--) {
            if (postorder[i] > root) return false;

            // 说明开始遍历到左子树部分了
            while (!stack.isEmpty() && stack.peek() > postorder[i]){
                root = stack.pop();
                stack.add(postorder[i]);
            }
        }

        return true;
    }
}
