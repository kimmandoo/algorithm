import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> arr = new ArrayList();
        HashMap<String, PriorityQueue<Song>> s = new HashMap();
        HashMap<String, Integer> g = new HashMap();
        for(int i = 0; i < genres.length; i++){
            g.put(genres[i], g.getOrDefault(genres[i], 0)+plays[i]); // 얘는 장르별 총 재생 수 넣게
            s.putIfAbsent(genres[i], new PriorityQueue<Song>((o1,o2)->{
                if(o2.plays == o1.plays){
                    // 재생수가 같으면 id가 낮은걸로 정렬
                    return o1.id - o2.id;
                }
                return o2.plays-o1.plays;
            }));
            s.get(genres[i]).add(new Song(i, plays[i]));
        } // 입력을 받았다. 각 장르 별로 plays 순 내림정렬, plays가 같으면 id 오름정렬.
        // 각 장르 별로 2개씩 뽑으면 되는데, 1개만 있다면 그거만 선택한다
        // 많이 재생된 장르를 먼저 수록한다 -> 이게 좀 애매
        
        // 키-값 쌍을 List로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList(g.entrySet());
        // value를 기준으로 내림차순 정렬
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        for(Map.Entry<String, Integer> entry: list){
            // 재생 수로 정렬된 키를 갖다가
            String genre = entry.getKey();
            int cnt = 0;
            while(cnt < 2){
                if(!s.get(genre).isEmpty()){
                    // 리스트가 남아있으면
                    arr.add(s.get(genre).poll().id);
                    cnt++;
                }else{
                    // 리스트가 비어있는 경우
                    break;
                }
            }
        }
        int[] answer = new int[arr.size()];
        int idx = 0;
        for(int id: arr){
            answer[idx++] = id;
        }
        
        return answer;
    }
}

class Song{
    int id; 
    int plays;
    Song(int id, int plays){
        this.id = id;
        this.plays = plays;
    }
}