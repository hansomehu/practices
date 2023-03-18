package sword2offer;

public class S19_RegMatch {

    public boolean isMatch(String s, String p){

        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*'){
            // two cases here for '*' pattern
            // match times >= 1
            // or
            // match 0 time
            return (first_match && isMatch(s.substring(1), p) )|| isMatch(s, p.substring(2));
        }else{
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
