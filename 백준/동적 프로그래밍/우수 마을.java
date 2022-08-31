import java.io.*;
import java.util.*;

/**
 * [1941] [DP] 우수 마을
 *
 * 동적 프로그래밍
 * 점화식 : dy[n][0] = 본인 선택 안 할 경우 주민 수 = max(자식이 자신 선택 한 경우, 자식이 자신 선택 안 한 경우)
 *        dy[n][1] = 본인 선택 할 경우 주민 수 = 본인 주민 수 + 자식들이 선택 안 한 경우 주민 수
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] weight;
    static int[][] dy;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        weight = new int[N + 1];
        dy = new int[N + 1][2];

        for(int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 1; i <= N; i++ ) weight[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }
    }

    static void run(){
        dfs(1);

        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }

    static void dfs(int v){
        visit[v] = true;
        dy[v][1] += weight[v];

        for(int next : adj[v]){
            if(!visit[next]){
                dfs(next);
                dy[v][0] += Math.max(dy[next][0], dy[next][1]);
                dy[v][1] += dy[next][0];
            }
        }
    }
}
