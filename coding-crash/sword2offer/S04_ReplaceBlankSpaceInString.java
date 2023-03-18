package sword2offer;

public class S04_ReplaceBlankSpaceInString {

    /**
     * 将一个字符串中的空格替换成“%20”
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     *
     * @hint: 从后往前复制，数组长度会增加；或使用StringBuilder、StringBuffer类
     */

    public String replace(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // String.valueOf(s.charAt(i)).equals(" ")
            if (s.charAt(i) == ' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return String.valueOf(sb);
    }
}
