import java.io.*;
import java.util.*;

/**
 * [15900] [트리] 나무 탈출
 *
 * 리프 노드의 depth 전부 더한게 홀수여야함
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int N;

    static class Node{
        int n;
        int depth;

        public Node(int n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int k = 1; k <= N; k++) adj[k] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }
    }

    static void run(){
        if(bfs(1) % 2 == 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }

    static int bfs(int start){
        int cnt = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visit[start] = true;

        while(!q.isEmpty()){
            Node current = q.poll();

            if(adj[current.n].size() == 1){
                cnt += current.depth;
            };

            for(int next : adj[current.n]){
                if(!visit[next]){
                    q.add(new Node(next, current.depth + 1));
                    visit[next] = true;
                }
            }
        }

        return cnt;
    }
}
