import java.io.*;
import java.util.*;

/**
 * [5567] [그래프] 결혼식
 *
 * bfs 를 통한 depth 계산
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static class People{
        int x;
        int depth;

        public People(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }
    }

    static void run(){
        System.out.println(bfs());
    }

    static int bfs(){
        int cnt = 0;

        Queue<People> q = new LinkedList<>();
        q.add(new People(1,0));
        visit[1] = true;

        while(!q.isEmpty()){
            People current = q.poll();
            cnt++;

            for(int next : adj[current.x]){
                if(current.depth < 2 && !visit[next]){
                    q.add(new People(next, current.depth + 1));
                    visit[next] = true;
                }
            }
        }

        return cnt -1 ;
    }

}
