import java.io.*;
import java.util.*;

/**
 * [2252] [위상 정렬] 줄 세우기
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static ArrayList<Integer>[] adj;
    static int N, M;
    static int[] indegree;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            indegree[v2] += 1;
        }
    }

    static void run(){
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");

            for(int next : adj[current]){
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }

        }

        System.out.println(sb);
    }



}
