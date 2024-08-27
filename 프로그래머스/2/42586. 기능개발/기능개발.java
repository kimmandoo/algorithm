import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> baepo = new ArrayList();
        // 뒤에있는 기능이 앞에있는 기능보다 먼저 개발될 수도 있고 앞 기능이 배포될 때 같이 배포
        // progress는 앞에 있는게 먼저 배포되어야됨 -> queue로 간다
        Queue<Task> q = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(new Task(progresses[i], speeds[i]));
        }
        ArrayList<Task> tmp = new ArrayList();
        while(!q.isEmpty()){
            // q가 다 빌 때 까지 돌린다.
            while(!q.isEmpty()){
                Task i = q.poll();
                tmp.add(new Task(i.p + i.s, i.s));
            }
            // 일단 하루 작업 끝 
            // 다시 q에 채워주기 전에 100이 넘는 애들 있나 확인
            int cnt = 0;
            int idx = 0;
            for(Task i: tmp){
                // 처음 원소부터
                if(i.p >= 100){
                    cnt++;
                    idx++;
                }else{
                    // 중간에 끊기면 끄기
                    // idx 부분 부터 q에 추가하면 됨
                    break;
                }
            } 
            for(int i = idx; i<tmp.size(); i++){
                q.offer(tmp.get(i));
            }
            if(cnt != 0){
                baepo.add(cnt);
            }
            tmp.clear();
        }
        int[] answer = new int[baepo.size()];
        int idx = 0;
        for(int b: baepo){
            answer[idx++] = b;
        }
        return answer;
    }
}

class Task{
    int p;
    int s;
    Task(int p, int s){
        this.p = p;
        this.s = s;
    }
}