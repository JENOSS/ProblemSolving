import java.io.*;
import java.util.*;

/**
 * [4963] [그래프] 섬의 개수
 * <p>
 * 그래프 탐색 개수
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static ArrayList<Island> testCase;

    static int R,C;
    static int[][] map;
    static boolean[][] visit;

    // 북, 북서, 북동, 남, 남서, 남동, 서, 동
    static int[] dr = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int[] dc = {0, -1, 1, 0, -1, 1, -1, 1};

    static class Island{
        int R;
        int C;
        int[][] map;
        boolean[][] visit;

        public Island(int r, int c) {
            R = r;
            C = c;
            map = new int[R][C];
            visit = new boolean[R][C];
        }
    }

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        testCase = new ArrayList<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (r == 0 && c == 0) break;

            Island island = new Island(r, c);

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for(int j = 0; j < c; j++){
                    island.map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            testCase.add(island);
        }
    }

    static void run(){

        StringBuilder sb = new StringBuilder();

        for(Island island : testCase){
            int cnt = 0;
            R = island.R;
            C = island.C;
            map = island.map;
            visit = island.visit;

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] == 1 && !visit[i][j]){
                        cnt++;
                        dfs(i,j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int r, int c){
        visit[r][c] = true;

        for(int i = 0; i < 8; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >=0 && nc >= 0 && nr < R && nc < C){
                if(map[nr][nc] == 1 && !visit[nr][nc]){
                    dfs(nr, nc);
                }
            }
        }
    }


}