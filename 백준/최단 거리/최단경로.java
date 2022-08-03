import java.io.*;
import java.util.*;

/**
 * [1753] [최단 거리] 최단경로
 *
 * 다익스트라 이용
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int[] dist;
    static ArrayList<Node>[] adj;
    static int N, M;
    static int start;

    static class Node{
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        start = Integer.parseInt(in.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e, d));
        }
    }

    static void run(){
        dijkstra(start);

        for(int i = 1; i <= N; i++){
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    static void dijkstra(int start){
        // 모든 정점까지에 대한 거리를 무한대로 초기화
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        // 최소 힙
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));

        // 시작점에 대한 정보를 기록에 추가하고, 거리 배열 갱신
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기처리
            if (dist[current.v] < current.dist) continue;

            for(Node next : adj[current.v]){
                if (dist[current.v] + next.dist >= dist[next.v]) continue;

                dist[next.v] = dist[current.v] + next.dist;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
    }

}
