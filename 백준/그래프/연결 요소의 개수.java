import java.io.*;
import java.util.*;

/**
 * [11724] [그래프] 연결 요소의 개수
 *
 * 그래프 탐색 개수
 * 주의 : 3 0 같은 경우 정답이 3임
 * **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int V, E;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V+1];
        visit = new boolean[V+1];

        for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void run(){
        int cnt = 0;

        for (int i = 1; i <= V; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int x){
        visit[x] = true;

        for(int next : adj[x]){
            if(!visit[next]) dfs(next);

        }
    }


}
