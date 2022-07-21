import java.io.*;
import java.util.*;

/**
 * [1389] [그래프] 케빈 베이컨의 6단계 법칙
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
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }
    }

    static void run(){
        int min = Integer.MAX_VALUE;
        int ans = 1;

        for(int i = 1; i <= N; i++){
            visit = new boolean[N + 1];
            int value = bfs(i);

            if(min > value){
                min = value;
                ans = i;
            }

            if(min == 1) break;
        }

        System.out.println(ans);
    }

    static int bfs(int x){
        int cnt = 0;

        Queue<People> q = new LinkedList<>();
        q.add(new People(x,0));
        visit[x] = true;

        while(!q.isEmpty()){
            People current = q.poll();
            cnt += current.depth;

            for(int next : adj[current.x]){
                if(!visit[next]){
                    q.add(new People(next, current.depth + 1));
                    visit[next] = true;
                }
            }
        }

        return cnt;
    }

}
