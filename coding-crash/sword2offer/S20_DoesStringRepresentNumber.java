package sword2offer;

import java.util.HashMap;
import java.util.Map;

public class S20_DoesStringRepresentNumber {
    /**
     * 表示数值的字符串
     * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/description/
     * 采用状态机来做，应该是全站当中唯一的用状态机解题
     */

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    public boolean isNumber(String s){
        // list all states and their possible next states and corresponding conditions
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>(); // store every state's next possible states
        Map<CharType, State> initialMap = new HashMap<CharType, State>(){{ // the eligible first element types and their possible corresponding states
            //put();
        }};
        transfer.put(State.STATE_INITIAL, initialMap);

        Map<CharType, State> intSignMap = new HashMap<CharType, State>(){{ // the next possible char types for current char "intSign"

        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)){ // illegal char type
                return false;
            }else {
                state = transfer.get(state).get(type);
            }
        }

        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;

    }




}
