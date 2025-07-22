import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean exist = false;
        for(String w: words){
            if(target.equals(w)) exist = true;
        }
        if(!exist) return 0;
        dfs(0, begin, target, words);
        return min;
    }
    
    static HashSet<String> v = new HashSet();
    // idx 번째 꺼가 같은 걸 골라서 변환하면 됨
    static int min = 100000000;
    public void dfs(int cnt, String str, String t, String[] words){
        if(cnt == words.length) return; // base
        if(str.equals(t)){
            min = Math.min(min, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!v.contains(words[i])){
                int dif = 0;
                for(int j=0; j<str.length(); j++){
                    if(str.charAt(j) != words[i].charAt(j)) dif++;
                }
                if(dif == 1){
                    v.add(words[i]);
                    dfs(cnt+1, words[i], t, words);
                    v.remove(words[i]);
                }
            }
        }
    }
    
}