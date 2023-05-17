package interview150.hash;

import java.util.*;
import java.util.stream.Collectors;

public class S49_GroupingAnagrams {
    /*
    https://leetcode.cn/problems/group-anagrams/
     */
    public List<List<String>> solution(List<String> words){

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            int[] alphabet = new int[26];
            for (char c :chars){
                alphabet[c - 'a'] += 1;
            }

            String keyPattern = alphabet.toString();
            if (map.containsKey(keyPattern)) {
                List<String> list = map.get(keyPattern);
                list.add(word);
                map.put(keyPattern, list);
            } else {
                map.put(keyPattern, new ArrayList<String>(){{
                    boolean add = add(word);
                }});
            }

        }

        return map.values().stream().collect(Collectors.toList());
    }
}
