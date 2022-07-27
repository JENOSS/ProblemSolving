import java.io.*;
import java.util.*;

/**
 * [2623] [위상 정렬] 음악 프로그램
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(in.readLine() , " ");
            st.nextToken();

            int pre = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int next = Integer.parseInt(st.nextToken());
                adj[pre].add(next);
                inDegree[next]++;
                pre = next;
            }
        }
    }

    static void run(){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int current = q.poll();

            sb.append(current).append("\n");
            cnt++;

            for(int next : adj[current]){
                inDegree[next]--;
                if(inDegree[next] == 0) q.add(next);
            }
        }

        if(cnt != N){
            System.out.println(0);
        }else{
            System.out.print(sb);
        }

    }



}
