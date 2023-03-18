package design_pattern;

public class Test {
    private String commonSubStr(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int res = 0;
        int start = 0, end = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = i+1; j < len2; j++) {
                String subStr = str1.substring(i, j);

                // 判断str2是否存在这个片段
                if(containsSubStr(str2, subStr)){
                    res = Math.max(res, j - i);
                    start = i;
                    end = j;
                }
            }
        }

        return str1.substring(start, end);
    }

    public boolean containsSubStr(String str2, String subStr){
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == subStr.charAt(0)){
                if (str2.substring(i, subStr.length()).equals(subStr)) return true;
            }
        }

        return false;
    }
}
