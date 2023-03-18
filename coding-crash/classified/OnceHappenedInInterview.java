package classified;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OnceHappenedInInterview {
    /*
    面试出现过的题目
     */


    /*
    给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数
    leetcode 233 hard
     */
    private int countDigitalOne(int n){

        return 0;
    }


    /*
    给定一个字符串，查找第一个不重复的字符(最优解法)
     */
    private String firstNonRepeatedChar(String str){
        char[] chars = str.toCharArray();
        int charLen = chars.length;
        String onlyChar = "";
        StringBuffer stringBuffer = new StringBuffer(""); // synchronized

        for (int i = 0; i < charLen; i++) {
            onlyChar = String.valueOf(chars[i]);
            stringBuffer.append(onlyChar);

            if (!(stringBuffer.indexOf(onlyChar) != (stringBuffer.length() - 1))){ // 在之前没有出现过
                if (str.substring(i+1, charLen).indexOf(onlyChar) == -1){ // 在之后没有出现过
                    return onlyChar;
                }
            }
        }

        return null;
    }

    /*

     */
    private boolean isPalindromeInteger(int n){
        if( n < 0 || ( n % 10 == 0 && n / 10 != 0)) return false; // 绝对不可能的情况

        int laterHalf = 0; // 整数后一半的值
        while( n > laterHalf){
            laterHalf = laterHalf * 10 + n % 10;
            n /= 10;
        }

        return laterHalf == n || laterHalf/10 == n;
    }


    /*

     */
    private String longestCommonPrefix(String[] strs){
        int len = strs.length;
        String prefix = strs[0];

        for (int i = 1; i < len; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if(prefix.length() == 0) return prefix;
        }

        return prefix;
    }

    /*

     */
    public String getPrefix(String str1, String str2){
        int len = Math.min(str1.length(), str2.length());

        int commonPrefixLen = 0;
        for (int i = 0; i < len; i++){
            if (str1.charAt(i) == str2.charAt(i)) commonPrefixLen++;
            else return str1.substring(0, commonPrefixLen);
        }

        return str1.substring(0, commonPrefixLen);
    }

    /*

     */
    private boolean validateParentheses(String s){
        Map<Character, Character> hashMap = new HashMap(){
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c)) stack.add(c);
            else if (hashMap.get(stack.pop()) != c) return false;
        }

        return stack.isEmpty();
    }

    /*
    排序数组中找到目标值，如果不存在返回其应该所在的下标
     */
    private int getIndex(int[] arr, int target){
        int r = arr.length - 1, l = 0;

        int mid = 0;
        while (r > l){
            mid = (l + r) / 2;
            if (arr[mid] > target) r = mid-1;
            else if (arr[mid] < target) l = mid+1;
            else return mid;
        }

        return arr[l] < target ? l+1 : l;
    }

    /*
    给定一个整数数组nums，找到一个具有最大和的连续子数组
     */
    private int subArr(int[] arr){
        int res = 0; // store the global optimal
        int preOpt = arr[0]; // store the maximum value of previous sub-arr

        for (int e : arr) {
            preOpt = Math.max(preOpt + e, e); // whether current element weight out previous sub-arr
            res = Math.max(preOpt, res);
        }

        return res;
    }

    /*

     */
    private int sqrt(int x){
        int n = 1, res = 0;

        while( x >= 0){
            x -= n;
            res++;
            n += 2;
        }

        return res -1;
    }

    /*

     */
    private int[] merge(int[] nums1, int m, int[] nums2, int n){
return null;
    }
    

    /*
    二叉树最大深度
     */


    /*
    二叉树到某一值的路径
     */
    
}
