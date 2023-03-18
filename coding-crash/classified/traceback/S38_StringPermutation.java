package classified.traceback;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 字符串的排列，经典的回溯算法题
 */
public class S38_StringPermutation {
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s){
        c = s.toCharArray();
        dfs(0);

        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        // 走到了末尾
        if (x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
           if (set.contains(c[i])) continue;
           set.add(c[i]);
           swap(i, x);
           dfs(x + 1);
           swap(i, x);
        }
    }

    private void swap(int a, int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
