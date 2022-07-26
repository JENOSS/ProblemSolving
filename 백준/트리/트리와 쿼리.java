import java.io.*;
import java.util.*;

/**
 * [15681] [트리] 트리와 쿼리
 *
 * countSubTree()를 이용해 먼저 계산 후 각 Q값을 가져오기
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static HashMap<Integer, Integer> size = new HashMap<>();
    static int[] question;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        question = new int[Q];

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(in.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        for(int i = 0; i < Q; i++){
            question[i] = Integer.parseInt(in.readLine());
        }
    }

    static void run(){
        StringBuilder sb = new StringBuilder();
        countSubTree(R);

        for(int q : question){
            sb.append(size.get(q)).append("\n");
        }

        System.out.print(sb);
    }

    static void countSubTree(int node){
        size.put(node, 1);
        visit[node] = true;

        for(int next : adj[node]){
            if(!visit[next]){
                countSubTree(next);
                size.put(node, size.get(node) + size.get(next));
            }
        }
    }
}
