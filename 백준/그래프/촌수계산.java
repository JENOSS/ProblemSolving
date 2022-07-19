import java.io.*;
import java.util.*;

/**
 * [2644] 촌수계산
 *
 * bfs 를 통한 depth 계산
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int V, E;
    static int V1, V2;
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
        V = Integer.parseInt(in.readLine());
        adj = new ArrayList[V + 1];
        visit = new boolean[V + 1];

        for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        E = Integer.parseInt(in.readLine());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);
        }
    }

    static void run(){
        System.out.println(bfs());
    }

    static int bfs(){
        int ans = -1;

        Queue<People> q = new LinkedList<>();
        q.add(new People(V1, 0));
        visit[V1] = true;

        while(!q.isEmpty()){
            People current = q.poll();

            if(current.x == V2){
                ans = current.depth;
                break;
            }

            for(int next : adj[current.x]){
                if(!visit[next]){
                    q.add(new People(next, current.depth + 1));
                    visit[next] = true;
                }
            }
        }

        return ans;
    }


}
