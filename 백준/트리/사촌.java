import java.io.*;
import java.util.*;

/**
 * [9489] [트리] 사촌
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static StringBuilder sb = new StringBuilder();

    static class Node{
        int parentIdx;
        int childCount = 0;

        public Node() {
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(n == 0 && k == 0) break;

            st = new StringTokenizer(in.readLine(), " ");

            Node[] tree = new Node[n];

            int pre = Integer.parseInt(st.nextToken());
            int parentIdx = 0;
            int kIdx = 0;

            tree[0] = new Node();
            tree[0].parentIdx = -1;

            for(int i = 1; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                tree[i] = new Node();

                if(k == v) kIdx = i;

                if (i != 1) {
                    if (pre + 1 != v) {
                        parentIdx++;
                    }
                }
                tree[parentIdx].childCount++;
                tree[i].parentIdx = parentIdx;
                pre = v;
            }

            run(kIdx, tree);
        }

        System.out.print(sb);
    }

    static void run(int kIdx, Node[] tree){

        int cnt = 0;

        for(int i = 1; i < tree.length; i++){
            if(tree[tree[i].parentIdx].parentIdx == tree[tree[kIdx].parentIdx].parentIdx &&
                tree[i].parentIdx != tree[kIdx].parentIdx){
                cnt++;
            }
        }


        sb.append(cnt).append("\n");
    }



}
