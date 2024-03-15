
import java.util.*;
import java.io.*;

public class Main {
    /*
    전위 순회 : 루트 - 왼쪽 - 오른쪽
    중위 순회 : 왼쪽 - 루트 - 오른쪽
    후위 순회 : 왼쪽 - 오른쪽 - 루트
    
    --sudo코드
    N숫자 입력받기
    for(N만큼){
     현재노드 입력받기
     왼쪽 입력받기
     오른쪽 입력받기
    }
     
     */
    static class Node {
        char alpha;
        Node left;
        Node right;

        Node(char alpha, Node left, Node right) {
            this.alpha = alpha;
            this.left = left;
            this.right = right;
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //노드의 개수 입력받기
        N = Integer.parseInt(br.readLine());
        Node head = new Node('A', null, null);
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            insertNode(head, parent, leftChild, rightChild);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
    }

    private static void postorder(Node head) {
        if(head == null) return;
        postorder(head.left);
        postorder(head.right);
        System.out.print(head.alpha);
    }

    private static void inorder(Node head) {
        if(head == null) return;
        inorder(head.left);
        System.out.print(head.alpha);
        inorder(head.right);
    }

    private static void preorder(Node head) {
        if(head == null) return;
        System.out.print(head.alpha);
        preorder(head.left);
        preorder(head.right);
    }

    private static void insertNode(Node root, char parent, char leftChild, char rightChild) {
        if (root.alpha == parent) {
            root.left = leftChild == '.' ? null : new Node(leftChild, null, null);
            root.right = rightChild == '.' ? null : new Node(rightChild, null, null);
        } else {
            if (root.left != null) insertNode(root.left, parent, leftChild, rightChild);
            if (root.right != null) insertNode(root.right, parent, leftChild, rightChild);
        }
    }


}
