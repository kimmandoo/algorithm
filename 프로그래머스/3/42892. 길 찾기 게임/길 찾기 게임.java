import java.util.*;

class Solution {

    // 노드 정보를 담을 클래스
    static class Node implements Comparable<Node> {
        int num, x, y;
        Node left, right;

        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        // y 내림차순, y 같으면 x 오름차순 정렬
        @Override
        public int compareTo(Node other) {
            if (this.y == other.y) {
                return this.x - other.x;
            }
            return other.y - this.y; // 내림차순 정렬
        }
    }

    // 전위, 후위 순회 결과를 저장할 배열의 인덱스
    int preIdx = 0;
    int postIdx = 0;

    public int[][] solution(int[][] nodeinfo) {
        // 1. Node 리스트 생성 및 정렬
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(nodes); // implement Comparable이 적용됨

        // 2. 트리 구축
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }

        // 3. 순회 결과 반환
        int[][] answer = new int[2][nodeinfo.length];
        preorder(root, answer[0]);
        postorder(root, answer[1]);

        return answer;
    }
    
    // 트리에 노드를 삽입하는 메서드
    public void insertNode(Node parent, Node child) {
        if (child.x < parent.x) { // 왼쪽 서브트리
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else { // 오른쪽 서브트리
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    public void preorder(Node node, int[] result) {
        if (node != null) {
            result[preIdx++] = node.num;
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    public void postorder(Node node, int[] result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result[postIdx++] = node.num; // 노드 번호를 결과에 저장
        }
    }
}