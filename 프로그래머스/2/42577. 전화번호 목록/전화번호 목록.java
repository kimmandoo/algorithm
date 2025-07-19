import java.util.*;

class Solution {
    public boolean solution(String[] pb) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String num : pb) {
            set.add(num);
        }

        for (String num : pb) {
            for (int i = 1; i < num.length(); i++) {
                String prefix = num.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        return answer;
    }
}