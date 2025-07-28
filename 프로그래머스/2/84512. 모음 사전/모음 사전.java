import java.util.*;

class Solution {
    static char[] t = new char[]{'A','E','I','O','U'};
    static TreeSet<String> ts = new TreeSet<>();

    static public void go(int idx, StringBuilder sb){
        if(idx > 5) return;

        if(sb.length() > 0) ts.add(sb.toString()); // 길이가 1 이상일 때 저장

        for(int i=0; i<5; i++){
            sb.append(t[i]);
            go(idx+1, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }

    public int solution(String word) {
        go(0, new StringBuilder());
        int cnt = 0;
        for(String s : ts){
            cnt++;
            if(s.equals(word)) return cnt;
        }
        return 0;
    }
}
