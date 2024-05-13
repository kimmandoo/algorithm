import java.util.*;
import java.io.*;


class Main {
	static class Room implements Comparable<Room>{
		int start, end;
		Room(int s, int e){
			start = s;
			end = e;
		}
		@Override
		public int compareTo(Room o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}else {
				return this.end - o.end;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<Room> r = new ArrayList();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			r.add(new Room(start, end));
		}
		Collections.sort(r); // 빨리 끝나는 걸 먼저 정해둔다.
		Deque<Room> res = new ArrayDeque();
		
		res.add(r.get(0)); // 첫번째꺼 넣고
		for(int i=1; i<r.size(); i++) {
			// r까지 다 돌기
			Room t = r.get(i);
			if(res.peekLast().end <= t.start) {
				res.add(t);
			}
		}
		System.out.print(res.size());
	}
}