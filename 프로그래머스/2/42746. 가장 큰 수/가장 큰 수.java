import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> str = new ArrayList();
        for(int i: numbers){
            str.add(String.valueOf(i));
        }
        Collections.sort(str, new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        if(str.get(0).equals("0")) return "0";
        
        StringBuilder ans = new StringBuilder();
        for(String s : str) {
            ans.append(s);
        }
        
        return ans.toString();
    }
}