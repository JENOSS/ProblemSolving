import java.io.*;
import java.util.*;

/**
 * [14502] [그래프] 연구소
 *
 * 벽을 먼저 세우고 (완전탐색) 안전 구역 검사 (bfs)
 * **/

public class Main {
    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M, max = 0;
    static int[][] A;
    static List<Coordinate> virus;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Coordinate{
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        virus = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int j = 0;
            while(st.hasMoreTokens()){
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == 2) virus.add(new Coordinate(i,j));
                j++;
            }
        }
    }

    public static void run() {
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                    dfs(depth + 1);
                    A[i][j] = 0;
                }

            }
        }
    }

    public static void bfs(){
        int[][] virusMap = getVirusMap();

        Queue<Coordinate> q = new LinkedList<>(virus);

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < N && nc < M){
                    if(virusMap[nr][nc] == 0){
                        virusMap[nr][nc] = 2;
                        q.add(new Coordinate(nr,nc));
                    }
                }
            }
        }

        max = Math.max(max,getVirusCount(virusMap));

    }

    private static int[][] getVirusMap(){
        int[][] virusMap = new int[N][M];

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                virusMap[i][j] = A[i][j];
            }
        }

        return virusMap;
    }

    private static int getVirusCount(int[][] map){
        int count = 0;

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 0) count++;
            }
        }

        return count;
    }



}