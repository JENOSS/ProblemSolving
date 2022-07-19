import java.io.*;
import java.util.*;

/**
 * [7565] [그래프] 나이트의 이동
 *
 * bfs 를 통한 depth 계산
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static StringBuilder sb = new StringBuilder();
    static TestCase[] testCases;
    static int N;


    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class TestCase{
        int N;
        boolean[][] visit;
        Coordinate start;
        Coordinate goal;

        public TestCase(int n, Coordinate start, Coordinate goal) {
            N = n;
            visit = new boolean[N][N];
            this.start = start;
            this.goal = goal;
        }
    }

    static class Coordinate{
        int r;
        int c;
        int depth;

        public Coordinate(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        testCases = new TestCase[N];

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(in.readLine());

            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            Coordinate start = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(in.readLine(), " ");
            Coordinate goal = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            testCases[i] = new TestCase(n, start, goal);
        }
    }

    static void run(){
        for(TestCase t : testCases){
            bfs(t);
        }

        System.out.print(sb);
    }

    static void bfs(TestCase t){
        int n = t.N;
        Coordinate start = t.start;
        Coordinate goal = t.goal;
        boolean[][] visit = t.visit;

        int depth = 0;

        Queue<Coordinate> q = new LinkedList<>();
        q.add(start);
        visit[start.r][start.c] = true;

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            if(current.r == goal.r && current.c == goal.c){
                depth = current.depth;
                break;
            }

            for(int i = 0; i < 8; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                    if(!visit[nr][nc]){
                        q.add(new Coordinate(nr, nc, current.depth + 1));
                        visit[nr][nc] = true;
                    }
                }
            }
        }

        sb.append(depth).append("\n");


    }



}
