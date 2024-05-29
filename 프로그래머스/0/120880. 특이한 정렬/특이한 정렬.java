import java.util.*;

class Node implements Comparable<Node>{
    int v, w;
    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
    
	@Override
	public int compareTo(Node o) {
		if(this.w == o.w) {
			return Integer.compare(o.v, this.v); // 가중치가 같으면 값이 큰게 먼저 와야됨
		}else {
			return Integer.compare(this.w, o.w); // 가중치가 더 큰게 멀리가야됨(오름차순)
		}
	}
}

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        List<Node> arr = new ArrayList<Node>();
        // 거리가 같으면 더 큰수를 반환함
        int idx = 0;
        for(int i: numlist){
            arr.add(new Node(numlist[idx], Math.abs(n-numlist[idx++])));
        }
        
        arr.sort(null);
        idx = 0;
        for(Node i: arr){
            answer[idx++] = i.v;
        }
        
        
        return answer;
    }
}