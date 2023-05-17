package interview150;

public class S125_IsPalindrome {
    /*
    https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&id=top-interview-150
     */
    private boolean solution(String str) {
        int n = str.length();
        int left = 0, right = n - 1;

        while (left <= right){
            if (Character.isLetterOrDigit(str.charAt(right)) ) {
                if (str.charAt(left) != str.charAt(right)) return false;
            } else {
                right += 1;
                continue;
            }

            left++;
            right++;
        }

        return true;
    }
}
