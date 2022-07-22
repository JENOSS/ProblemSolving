import java.io.*;
import java.util.*;

/**
 * [4863] [트리] 트리
 *
 * 트리의 조건 : 정점 V -> 간선 V - 1 개
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static ArrayList<TestCase> testCases;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int subV = 0, subE = 0;

    static class TestCase{
        int V, E;
        ArrayList<Integer>[] adj;

        public TestCase(int v, int e, ArrayList<Integer>[] adj) {
            V = v;
            E = e;
            this.adj = adj;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        testCases = new ArrayList<>();

        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(v == 0 && e == 0) break;

            ArrayList<Integer>[] adj = new ArrayList[v + 1];

            for(int i = 1; i <= v; i++) adj[i] = new ArrayList<>();

            for(int i = 0; i < e; i++){
                st = new StringTokenizer(in.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                adj[v1].add(v2);
                adj[v2].add(v1);
            }

            testCases.add(new TestCase(v,e,adj));
        }
    }

    static void run(){
        StringBuilder sb = new StringBuilder();
        int k = 1;

        for(TestCase t : testCases){
            int cnt = 0;

            adj = t.adj;
            visit = new boolean[t.V + 1];

            for(int i = 1; i <= t.V; i++){
                if(!visit[i]){
                    subV = 0;
                    subE = 0;
                    dfs(i);
                    subE = subE/2;
                    if(subV - 1 == subE) cnt++;
                }
            }

            sb.append(String.format("Case %d: ",k));

            if(cnt == 0){
                sb.append("No trees.");
            }else if(cnt == 1){
                sb.append("There is one tree.");
            }else{
                sb.append(String.format("A forest of %d trees.",cnt));
            }

            sb.append("\n");
            k++;
        }

        System.out.print(sb);
    }

    static void dfs(int x){
        visit[x] = true;
        subV++;

        for(int next : adj[x]){
            subE++;
            if(!visit[next]){
                dfs(next);
            }
        }
    }

}
