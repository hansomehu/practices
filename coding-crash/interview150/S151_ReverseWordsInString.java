package interview150;

import java.util.*;

public class S151_ReverseWordsInString {
    /*
    https://leetcode.cn/problems/reverse-words-in-a-string/solutions/?envType=study-plan-v2&id=top-interview-150
    可以说是最简单的中等题没有之一
     */
    private String solution1(String words){
        // java api快速操作 空间O（n）
        String s = words.trim();
        List<String> words2 = Arrays.asList(s.split(" "));
        Collections.reverse(words2);

        return String.join(" ", words);
    }

    // 原始操作，用栈char by char地进行处理 空间O(1)
    private String solutions2(String s){
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
    }

