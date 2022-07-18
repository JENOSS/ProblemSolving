import java.io.*;
import java.util.*;

/**
 * [11725] [그래프] 트리의 부모 찾기
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] root;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(in.readLine());
        adj = new ArrayList[V + 1];
        visit = new boolean[V + 1];
        root = new int[V + 1];

        for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < V - 1; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adj[v1].add(v2);
            adj[v2].add(v1);
        }
    }

    static void run(){
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= V; i++){
            sb.append(root[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x){
        visit[x] = true;

        for(int next : adj[x]){
            if(!visit[next]){
                root[next] = x;
                dfs(next);
            }
        }
    }




}