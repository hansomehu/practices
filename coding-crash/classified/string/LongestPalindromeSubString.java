package classified.string;

public class LongestPalindromeSubString {

    // violent solution
    boolean isPalindrome(String s){
        int r = s.length();
        int l = 0;

        while(r >= l){
            if (s.charAt(r) != s.charAt(l)) return false;
            r--;
            l++;
        }

        return true;
    }

    public String solution_violent(String s){
        int len = s.length();

        String res = "";
        for (int i = 0; i < len - 1; i++){
            for (int j = i+1; j < len; j++){
                if (isPalindrome(s.substring(i, j))){
                    res = (res.length() - s.substring(i, j).length())
                            >= 0 ? res : s.substring(i, j);
                }
            }
        }

        return res;
    }

    // dynamic planning solution
    public String solution_dp(String s){
        int len = s.length();
        if (len <= 1) return s;

        boolean[][] map = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            map[i][i] = true;
        }

        int max = 1, start = 0;

        // s.toCharArray will great boost the execute time
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j && i < len - 1; i++){
                if (s.charAt(i) != s.charAt(j)){
                    map[i][j] = false;
                }else{
                    if (j - 1 < 3){
                        map[i][j] = true;
                    }else {
                        map[i][j] = map[i+1][j-1];
                    }
                }

                if (map[j][j] && j-i+1 > max){
                    max = j-1+1; // the length of palindrome sub string
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }
}
