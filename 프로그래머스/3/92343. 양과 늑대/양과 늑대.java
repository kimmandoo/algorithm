import java.util.*;

class Solution {
    
    // 각 노드의 자식 노드를 저장할 인접 리스트
    static ArrayList<Integer>[] children;
    // info 배열을 전역으로 사용
    static int[] nodeInfo;
    // 최대 양의 수를 저장할 변수
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        nodeInfo = info;
        children = new ArrayList[info.length];

        // 1. 인접 리스트로 트리 구조 만들기
        for (int i = 0; i < info.length; i++) {
            children[i] = new ArrayList<>();
        } // 놀랍게도 이거 했다.
        // Node클래스를 일부러 만드려는 그런 안일한 생각 버리기
        for (int[] edge : edges) {
            children[edge[0]].add(edge[1]); // 부모노드에 자식노드 추가
        }

        // 2. 다음에 방문할 수 있는 노드들을 담을 리스트
        ArrayList<Integer> nextNodes = new ArrayList<>();
        // 루트(0번) 노드의 자식들을 초기에 추가
        for (int child : children[0]) {
            nextNodes.add(child);
        }

        // 3. DFS 탐색 시작
        // 시작은 0번 노드에서 양 1마리, 늑대 0마리로 시작
        dfs(1, 0, nextNodes);

        return maxSheep;
    }

    /**
     * @param sheep      현재까지 모은 양의 수
     * @param wolf       현재까지 모은 늑대의 수
     * @param nextNodes  현재 상태에서 다음에 방문 가능한 노드들의 목록
     */
    public void dfs(int sheep, int wolf, ArrayList<Integer> nextNodes) {
        // 1. 현재 양의 수로 최댓값 갱신
        maxSheep = Math.max(maxSheep, sheep);

        // 2. 다음에 방문할 노드가 없다면 탐색 종료
        if (nextNodes.isEmpty()) {
            return;
        }

        // 3. 다음에 방문 가능한 모든 노드에 대해 재귀적으로 탐색
        for (int i = 0; i < nextNodes.size(); i++) {
            int nextNode = nextNodes.get(i);
            
            // 다음 노드의 정보 (0: 양, 1: 늑대)
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (nodeInfo[nextNode] == 0) { // 양인 경우 -> info 배열을 복사했다. swallow copy
                nextSheep++;
            } else { // 늑대인 경우
                nextWolf++;
            }
            
            // 4. 방문 조건 확인: 늑대가 양보다 많아지면 해당 경로는 더 이상 탐색하지 않음
            if (nextWolf >= nextSheep) {
                continue;
            }

            // 5. 다음 탐색을 위한 준비 -> 아직 양이 더 많을 경우
            // 현재 상태의 nextNodes를 복사하여 다음 재귀 호출에 넘겨줌
            ArrayList<Integer> newNextNodes = new ArrayList<>(nextNodes); // 이렇게 하면copy가 됨
            // 방금 방문한 노드는 목록에서 제거
            newNextNodes.remove(Integer.valueOf(nextNode)); // int도 Integer로 변환해야된다
            // 방금 방문한 노드의 자식들을 다음에 방문 가능한 목록에 추가
            for (int child : children[nextNode]) { // children에는 각 노드의 자식노드들이 저장되어 있다.
                newNextNodes.add(child);
            }
            
            // 6. 재귀 호출
            dfs(nextSheep, nextWolf, newNextNodes);
        }
    }
}