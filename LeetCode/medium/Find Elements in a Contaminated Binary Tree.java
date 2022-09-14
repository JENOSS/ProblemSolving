import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * [medium] [1261] Find Elements in a Contaminated Binary Tree
 *
 * 목적에 맞는 함수 만들기
 **/

public class Main {

    public static void main(String[] args) throws IOException {

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

    class FindElements {
        private HashSet<Integer> hs = new HashSet<>();

        public FindElements(TreeNode root) {
            dfs(true, false, -1, root);
        }

        public void dfs(boolean isRoot, boolean isLeft, int parentVal, TreeNode node){
            if(isRoot){
                node.val = 0;
            } else{
                node.val = isLeft ? 2 * parentVal + 1 : 2 * parentVal + 2;
            }

            hs.add(node.val);

            if(node.left != null) dfs(false, true, node.val, node.left);
            if(node.right != null) dfs(false, false, node.val, node.right);
        }

        public boolean find(int target) {
            return hs.contains(target);
        }
    }
}
