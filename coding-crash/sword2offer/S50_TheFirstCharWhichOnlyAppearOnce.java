package sword2offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class S50_TheFirstCharWhichOnlyAppearOnce {

    /*
    https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
    学习使用LinkHashMap来构建有序hash
     */
    private Character solution(String str){
        LinkedHashMap<Character, Boolean> zMap = new LinkedHashMap<>();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (zMap.containsKey(c)){
                zMap.put(c, true);
            } else zMap.put(c, false);
        }

        for (Map.Entry<Character, Boolean> characterBooleanEntry : zMap.entrySet()) {
            if (characterBooleanEntry.getValue() == false) return characterBooleanEntry.getKey();
        }

        return null;
    }
}
