import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        LinkedList<Character> stack = new LinkedList();
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(stack.isEmpty()){
                if(tmp == ')') return false; 
                stack.add(tmp);
            }
            else if(stack.peekLast() != tmp){
                stack.pollLast();
            }else{
                stack.add(tmp);
            }
        }
        if(stack.size() != 0){
            answer = false;
        }

        return answer;
    }
}