package interview150.double_pointers;

public class S392_IsSubSequence {
    /*
    https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&id=top-interview-150
     */
    private boolean solution(String orig, String sub){
        int l = orig.length(), s = sub.length();
        int i = 0, j = 0;

        while (i < l && j < s){
            if (orig.charAt(i) == sub.charAt(j)) i++;
            j++;
        }

        return j == s;
    }
}
