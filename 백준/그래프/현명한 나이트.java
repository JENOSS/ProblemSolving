import java.io.*;
import java.util.*;

/**
 * [18404] [그래프] 현명한 나이트
 *
 * bfs 를 통한 depth 계산
 * 순서 보장 위해 먼저 depth 계산 후 goal 의 depth 확인
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static Coordinate start;
    static Coordinate[] goals;
    static int[][] depth;

    static int[] dr = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dc = {-2, -2, -1, -1, 1, 1, 2, 2};

    static class Coordinate{
        int r;
        int c;
        int depth;

        public Coordinate(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        public boolean isEqual(Coordinate o){
            return  r == o.r && c == o.c;
        }

    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        goals = new Coordinate[M];
        depth = new int[N + 1][N + 1];

        st = new StringTokenizer(in.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        start = new Coordinate(r,c,0);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            goals[i] = new Coordinate(r,c,0);
        }

    }

    static void run(){
        StringBuilder sb = new StringBuilder();

        bfs();
        for(Coordinate g : goals){
            sb.append(depth[g.r][g.c]).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(){
        int ans = 0;

        Queue<Coordinate> q = new LinkedList<>();
        q.add(start);
        depth[start.r][start.c] = -1;

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            for(int i = 0; i < 8; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr > 0 && nc > 0 && nr <= N && nc <= N){
                    if(depth[nr][nc] == 0){
                        q.add(new Coordinate(nr,nc,current.depth + 1));
                        depth[nr][nc] = current.depth + 1;
                    }
                }
            }
        }

        return ans;
    }


}
