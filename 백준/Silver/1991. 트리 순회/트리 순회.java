import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[n + 1];
        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 문자열 분리
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            // java는 char값을 ascii 라고 봐도 무방함.
            if (tree[p-'A'] == null){ // char 값이 A를 빼주면 int 값으로 0부터 26이 된다.
                tree[p-'A'] = new Node(p); // 부모 노드가 없으니까 생성해줌
            }
            if (l != '.') { // 왼쪽 자식이 존재할 경우
                tree[l - 'A'] = new Node(l); // 왼쪽 자식 노드를 생성
                tree[p - 'A'].left = tree[l - 'A']; // 부모 노드와 연결 -> 이렇게 해야 트리가 연결된다.
            }
            if (r != '.') { // 오른쪽 자식이 존재할 경우
                tree[r - 'A'] = new Node(r); // 오른쪽 자식 노드를 생성
                tree[p - 'A'].right = tree[r - 'A']; // 부모 노드와 연결
            }

        }

        // 전위 순회
        preorder(tree[0]);
        System.out.println();

        // 중위 순회
        inorder(tree[0]);
        System.out.println();

        // 후위 순회
        postorder(tree[0]);
        System.out.println();
    }
}
