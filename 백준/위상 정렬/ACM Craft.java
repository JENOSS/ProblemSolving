import java.io.*;
import java.util.*;

/**
 * [1005] [위상 정렬] ACM Craft
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static int N, K;
    static int[] inDegree;
    static int[] done;
    static int[] time;
    static ArrayList<Integer>[] adj;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCnt = Integer.parseInt(in.readLine());

        for(int i = 0; i < testCaseCnt; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            inDegree = new int[N + 1];
            time = new int[N + 1];
            done = new int[N + 1];
            adj = new ArrayList[N + 1];

            st = new StringTokenizer(in.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                adj[j] = new ArrayList<>();
                time[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(in.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                adj[v1].add(v2);
                inDegree[v2]++;
            }

            run(Integer.parseInt(in.readLine()));
        }

        System.out.print(sb);
    }

    static void run(int goal){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0) {
                q.add(i);
                done[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : adj[current]){
                inDegree[next]--;
                if(inDegree[next] == 0) q.add(next);
                done[next] = Math.max(done[next], done[current] + time[next]);
            }
        }


        sb.append(done[goal]).append("\n");

    }



}
