import java.io.*;
import java.util.*;

/**
 * [1516] [위상 정렬] 게임 개발
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;
    static int[] done;
    static int[] time;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        inDegree = new int[N + 1];
        done = new int[N + 1];
        time = new int[N + 1];

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            int parent = 0;
            while((parent = Integer.parseInt(st.nextToken())) != -1){
                adj[parent].add(i);
                inDegree[i]++;
            }
        }
    }

    static void run(){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                q.add(i);
                done[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : adj[current]){
                inDegree[next]--;
                done[next] = Math.max(done[next], done[current] + time[next]);
                if(inDegree[next] == 0) q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) sb.append(done[i]).append("\n");

        System.out.print(sb);
    }

}
