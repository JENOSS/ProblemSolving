import java.io.*;
import java.util.*;

/**
 * [2178] [그래프] 미로탐색
 *
 * bfs : 최소 이동 횟수 계산 가능
 * 키워드 : 최소 이동 횟수, 최단 시간
 * **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int[][] A;
    static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

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

    public static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = in.readLine();
            for(int j = 0; j < M; j++){
                A[i][j] = s.charAt(j) - 48;
            }
        }
    }

    public static void run(){
        System.out.println(bfs());
    }

    public static int bfs(){
        int min = Integer.MAX_VALUE;

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0,0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()){
            Coordinate current = q.poll();
            if(current.r == N - 1 && current.c == M - 1){
                min = Math.min(min, current.depth);
            }

            for(int i = 0; i < 4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < N && nc < M ){
                    if(A[nr][nc] == 1 && !visit[nr][nc]){
                        q.add(new Coordinate(nr, nc, current.depth + 1));
                        visit[nr][nc] = true;
                    }
                }
            }
        }

        return min + 1;
    }

}