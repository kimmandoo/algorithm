import java.util.*;

class Solution {
    boolean solution(String s) {
        LinkedList<Character> st = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                st.addLast(c);
            } else { // c == ')'
                if (st.isEmpty()) {
                    return false;
                }
                st.removeLast(); // 짝이 맞으면 pop
            }
        }
        
        return st.isEmpty(); // 다 짝 맞으면 비어 있어야 함
    }
}