import java.io.*;
import java.util.*;

/**
 * [11403] [그래프] 경로 찾기
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int j = 1; j <= N; j++){
                if(Integer.parseInt(st.nextToken()) == 1) adj[i].add(j);
            }
        }

    }

    static void run(){
        for(int i = 1; i <= N; i++){
            visit = new boolean[N + 1];
            bfs(i);
        }
        System.out.print(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : adj[current]){
                if(!visit[next]){
                    q.add(next);
                    visit[next] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            sb.append(visit[i] ? 1 : 0).append(' ');
        }

        sb.append("\n");
    }





}