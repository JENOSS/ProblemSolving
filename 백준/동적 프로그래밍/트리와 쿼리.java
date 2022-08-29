import java.io.*;
import java.util.*;

/**
 * [15681] [DP] 트리와 쿼리
 *
 * 동적 프로그래밍
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int[] dy;
    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static int[] question;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dy = new int[N + 1];
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        question = new int[Q];

        for(int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        for(int i = 0; i < Q; i++) question[i] = Integer.parseInt(in.readLine());
    }

    static void run(){
        StringBuilder sb = new StringBuilder();

        dfs(R);

        for(int q : question){
            sb.append(dy[q]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int v){
        dy[v] = 1;
        visit[v] = true;

        for(int next : adj[v]){
            if(!visit[next]){
                dfs(next);
                dy[v] += dy[next];
            }
        }
    }
}
