import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    static int size = 0;

    static class Node {
        HashMap<Character, Node> child;
        boolean endOfWord;

        public Node() {
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public boolean insert(String str) {
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                node.child.putIfAbsent(c, new Node());
                node = node.child.get(c);

                if (node.endOfWord) return false;
                if (i == str.length() - 1) {
                    if (!node.child.isEmpty()) return false;
                    node.endOfWord = true;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            size = Integer.parseInt(br.readLine().trim());
            Trie trie = new Trie();
            boolean isConsistent = true;

            for (int i = 0; i < size; i++) {
                String phoneNumber = br.readLine().trim();
                if (isConsistent && !trie.insert(phoneNumber)) {
                    isConsistent = false;
                }
            }

            if (isConsistent) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}