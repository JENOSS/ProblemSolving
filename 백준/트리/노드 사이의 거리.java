import java.io.*;
import java.util.*;

/**
 * [1240] [트리] 노드 사이의 거리
 *
 * start -> end 까지 dfs
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static int N, M;
    static int[][] distance;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();
    static int value = 0;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1][N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 1 ; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0 ; i < N - 1; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[n1].add(n2);
            adj[n2].add(n1);
            distance[n1][n2] = d;
            distance[n2][n1] = d;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            run(n1,n2);
        }

        System.out.print(sb);
    }

    static void run(int v1, int v2){
        if(distance[v1][v2] != 0){
            sb.append(distance[v1][v2]).append("\n");
        }else{
            value = 0;
            visit = new boolean[N + 1];
            dfs(v1,v2,0);
            sb.append(value).append("\n");
        }
    }

    static void dfs(int start, int end, int depth){
        if(start == end){
            value += depth;
            return;
        }

        visit[start] = true;

        for(int next : adj[start]){
            if(!visit[next]){
                dfs(next, end, depth + distance[start][next]);
            }
        }
    }


}
