import java.io.*;
import java.util.*;

/**
 * [2606] [그래프] 바이러스
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int V,E,CNT = 0;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(in.readLine());
        E = Integer.parseInt(in.readLine());
        adj = new ArrayList[V + 1];
        visit = new boolean[V + 1];

        for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }
    }

    static void run(){
        dfs(1);
        System.out.println(CNT);
    }

    static void dfs(int v){
        visit[v] = true;

        for(int next : adj[v]){
            if(!visit[next]){
                dfs(next);
                CNT++;
            }
        }
    }



}