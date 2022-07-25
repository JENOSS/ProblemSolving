import java.io.*;
import java.util.*;

/**
 * [5639] [트리] 이진 검색 트리
 *
 * 전위 순회를 통해 트리를 구축하고 후위 순회로 출력
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static StringBuilder sb = new StringBuilder();
    static Node root;

    static class Node{
        int n;
        Node left;
        Node right;

        public Node(int n) {
            this.n = n;
        }

    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        root = new Node(Integer.parseInt(s));

        while(true){
            s = in.readLine();
            if(s != null && !s.isEmpty()){
                setNode(root, new Node(Integer.parseInt(s)));
            }else{
                break;
            }
        }
    }

    static void setNode(Node startNode, Node setNode){
        if(setNode.n < startNode.n){
            if(startNode.left != null){
                setNode(startNode.left, setNode);
            }else{
                startNode.left = setNode;
            }
        }else{
            if(startNode.right != null){
                setNode(startNode.right, setNode);
            }else{
                startNode.right = setNode;
            }
        }
    }

    static void run(){
        postOrder(root);
        System.out.print(sb);
    }

    static void postOrder(Node node){
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        sb.append(node.n).append("\n");
    }
}
