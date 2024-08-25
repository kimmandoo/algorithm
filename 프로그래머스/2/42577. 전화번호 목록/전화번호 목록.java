import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        TreeSet<String> ts = new TreeSet();
        for(String phone: phone_book){
            ts.add(phone);
        }
        
        // 각 전화번호의 모든 접두어를 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) { // 길이는 1이상
                String prefix = phone.substring(0, i);
                if (ts.contains(prefix)) {
                    answer = false;
                }
            }
        }
        
        return answer;
    }
}