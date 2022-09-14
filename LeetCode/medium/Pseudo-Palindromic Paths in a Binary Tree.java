import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * [medium] [1457] Pseudo-Palindromic Paths in a Binary Tree
 *
 * 각 정수의 발생 횟수가 홀수 인지 짝수인지 확인하고
 * 각 정수의 발생 횟수가 전부다 짝수 이거나, 홀수가 있다면 홀수는 무조건 1개의 정수만 해당해야 palindrome 이다.
 * 즉 각 정수의 발생 횟수를 체크하다 홀수의 발생 횟수가 2개 이상이면 증가시키지 않을 것
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);

        System.out.print(pseudoPalindromicPaths(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

    static int ans =0; // palindrome 수 저장
    static int[] arr = new int[10]; // 각 정수의 출현 빈도 저장

    public static int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return ans;
    }

    private static void helper(TreeNode node){
        if(node == null) return ; // 리프 노드의 left, right 를 호출 할 수도 있고 그 노드는 비어있을 수 있다

        arr[node.val]++; // 해당 노드의 원소의 출현 빈도 추가

        if(node.left == null && node.right == null) {// 리프 노드인 경우 palindrome 인지 체크

            // 각 정수의 발생 횟수가 홀수 인지 짝수인지 확인하고
            // 만약 발생 횟수가 홀수인게 2개 이상이면 증가시키지 않을 것
            // 즉 각 정수의 발생 횟수가 전부다 짝수 이거나, 홀수가 있다면 홀수는 무조건 1개의 정수만 해당해야 palindrome 이다.
            int count = 0;
            for (int i = 1; i <= 9; i++) {
                count += arr[i] % 2;
            }

            if (count == 1 || count == 0) ans++;

        }

        helper(node.left);
        helper(node.right);
        arr[node.val]--; // 해당 노드 추가한 기록 제거

    }
}
