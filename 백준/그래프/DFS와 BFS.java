import java.io.*;
import java.util.*;

/**
 * [1260] [그래프] DFS와 BFS
 *
 * DFS : 재귀 or 스택
 * BFS : 큐
 **/

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        for(int i = 1; i <= N; i++) Collections.sort(adj[i]);
    }

    static void run(){
        dfs(V);

        visit = new boolean[N + 1];
        sb.append('\n');

        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int v){
        sb.append(v).append(' ');
        visit[v] = true;

        for(int next : adj[v]){
            if(visit[next]) continue;

            dfs(next);
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visit[v] = true;

        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(' ');

            for(int next : adj[current]){
                if(visit[next]) continue;

                q.add(next);
                visit[next] = true;
            }
        }
    }

}