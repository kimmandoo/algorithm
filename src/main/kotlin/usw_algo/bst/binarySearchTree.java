package usw_algo.bst;

import java.util.ArrayList;
import java.util.Arrays;

public class binarySearchTree {
    Node head = null;

    public class Node {
        Node lNode; // left child
        Node rNode; // right child
        int value;

        public Node(int data) {
            value = data;
            lNode = null;
            rNode = null;
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(90, 2, 7, 1, 50, 40, 21, 19, 3, 11));
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 7, 11, 19, 21, 40, 50, 90));
        binarySearchTree bst = new binarySearchTree();

        for (int i : input) {
            bst.insert(i);
        }
//        System.out.println(input);
    }

    public Node search(int data) {
        if (head == null) return null;
        else {
            Node searchNode = head;
            while (searchNode != null) {
                if (searchNode.value == data) return searchNode;
                else if (data < searchNode.value) {
                    //찾으려는 값이 현재 노드 보다 작음 -> lNode로 가야됨
                    searchNode = searchNode.lNode;
                } else {
                    //rNode
                    searchNode = searchNode.rNode;
                }
            }
        }
        return null;
    }

    public void insert(int data) {
        if (head == null) {
            //트리가 존재하지 않을때
            head = new Node(data);
        } else {
            Node insertNode = head;
            while (true) {
                if (data < insertNode.value) {
                    // left
                    if (insertNode.lNode != null) {
                        // null인 lNode 찾으러 가기
                        insertNode = insertNode.lNode;
                    } else {
                        insertNode.lNode = new Node(data);
                        break;
                    }
                } else {
                    // right
                    if (insertNode.rNode != null) {
                        insertNode = insertNode.rNode;
                    } else {
                        insertNode.rNode = new Node(data);
                        break;
                    }
                }
            }
        }
    }

    public boolean delete(int data) {
        //child node가 1개일때 -> 부모노드 가리키는 걸 child노드로 이동
        // 삭제할 노드의 오른쪽 자식 중 가장 작은 값을 삭제할 노드의 부모 노드가 가리키게, 그리고 swap후 삭제함  -> bst가 유지되면서 삭제를 할수있음
        // 반대는 삭제할 노드의 왼쪽 자식 중 가장 큰 값을 삭제할 노드와 바꾸면 됨
        boolean searched = false;
        Node pNode = head;
        Node delNode = head;
        if (head == null) return false;
        else {
            if (head.value == data && head.lNode == null && head.rNode == null) {
                head = null;
                return true;
            }
            // =======
            while (delNode != null) {
                if (delNode.value == data) {
                    searched = true;
                    break;
                } else if (data < delNode.value) {
                    pNode = delNode;
                    delNode = delNode.lNode;
                } else {
                    pNode = delNode;
                    delNode = delNode.rNode;
                }
            }
            if (searched == false) {
                return false;
            }
        }
        // 이제 삭제할 차례
        // 삭제할 노드가 leaf인 경우 -> 부모 브랜치를 끊어버림
        if (delNode.lNode == null && delNode.rNode == null) {
            if (data < delNode.value) {
                pNode.lNode = null;
                delNode = null;
            } else {
                pNode.rNode = null;
                delNode = null;
            }
        } else if (delNode.lNode != null && delNode.rNode == null) {
            // 삭제할 노드가 child 1개를 갖고있는 경우 -> 좌, 우 케이스 쪼개서 생각함
            // 왼쪽에 child node
            if (data < pNode.value) {
                // child node의 방향은 고정
                pNode.lNode = delNode.lNode;
            } else {
                pNode.rNode = delNode.lNode;
            }
        } else if (delNode.lNode == null && delNode.rNode != null) {
            // 삭제할 노드가 child 1개를 갖고있는 경우 -> 좌, 우 케이스 쪼개서 생각함
            if (data < pNode.value) {
                pNode.lNode = delNode.rNode;
            } else {
                pNode.rNode = delNode.rNode;
            }
            return true;
        } else if (delNode.lNode != null && delNode.rNode != null) {
            // 삭제할 노드가 child를 2개 다 갖고있는 경우 -> 서브트리를 갖고있는 경우
            if (data < pNode.value) {
                // 삭제할 노드가 부모 왼쪽에 있을 때
                Node tmpNode = delNode.rNode;
                Node pTmpNode = delNode.rNode;
                // 삭제할 노드의 오른쪽 자식 중, 가장 작은 노드 찾기
                while (delNode.lNode != null) {
                    pTmpNode = delNode;
                    tmpNode = delNode.lNode;
                }
                // 여기까지 실행되면, tmpNode 에는 delNode의 오른쪽 자식의 서브트리 중 가장 작은값이 들어있음(왼쪽으로 계속 들어갔기 때문)
                // 이제 tmpNode에 child가 붙어있을 경우를 생각해야됨.
                if (tmpNode.rNode != null) {
                    pTmpNode.lNode = tmpNode.rNode;
                } else {
                    pTmpNode.lNode = null;
                }
                pNode.lNode = tmpNode;
                tmpNode.rNode = delNode.rNode;
                tmpNode.lNode = delNode.lNode;
                delNode = null;
            } else {
                // 삭제할 노드가 부모 오른쪽에 있을 때
                // 삭제할 노드의 오른쪽 자식 중, 가장 작은 노드 찾기
                Node tmpNode = delNode.rNode;
                Node pTmpNode = delNode.rNode;
                while (tmpNode.lNode != null) {
                    pTmpNode = tmpNode;
                    tmpNode = tmpNode.lNode;
                }
                if (tmpNode.rNode != null) {
                    pTmpNode.lNode = tmpNode.rNode;
                } else {
                    pTmpNode.lNode = null;
                }

                pNode.rNode = tmpNode;
                tmpNode.rNode = delNode.rNode;
                tmpNode.lNode = delNode.lNode;
            }
            return true;
        }
        return false;
    }
}
