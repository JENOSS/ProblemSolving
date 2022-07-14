import java.io.*;
import java.util.*;

/**
 * [1012] [그래프] 유기농 배추
 *
 * 그래프 탐색 개수
 * **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int T;
    static TestCase[] testCases;

    static int R, C, K, visitCount;
    static int[][] map;
    static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    static class TestCase {
        int R,C;
        int K;
        int[][] map;
        boolean[][] visit;

        public TestCase(int c, int r, int k) {
            R = r;
            C = c;
            K = k;

            map = new int[R][C];
            visit = new boolean[R][C];
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());
        testCases = new TestCase[T];

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            testCases[i] = new TestCase(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int j = 0; j < testCases[i].K; j++){
                st = new StringTokenizer(in.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                testCases[i].map[r][c] = 1;
            }
        }
    }

    static void run(){

        StringBuilder sb = new StringBuilder();

        for(TestCase t : testCases){
            int cnt = 0;

            map = t.map;
            visit = t.visit;
            visitCount = 0;

            R = t.R;
            C = t.C;
            K = t.K;

            Loop1 :
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(visitCount == K) break Loop1;

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
        visitCount++;

        if(visitCount == K) return;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nc >= 0 && nr < R && nc < C){
                if(map[nr][nc] == 1 && !visit[nr][nc]){
                    dfs(nr,nc);
                }
            }
        }
    }


}