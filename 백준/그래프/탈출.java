import java.io.*;
import java.util.*;

/**
 * [3055] [그래프] 탈출
 *
 * 최소 개수로 간선 이동
 * **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int R, C, min = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][] visit;
    static int[][] waterDistance;

    static ArrayList<Coordinate> waters;
    static Coordinate S;
    static Coordinate D;

    static class Coordinate {
        int r;
        int c;
        int depth;

        public Coordinate(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        waterDistance = new int[R][C];
        waters = new ArrayList<>();

        for(int i = 0; i < R; i++){
            String s = in.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'D') D = new Coordinate(i,j,0);
                if(map[i][j] == 'S') S = new Coordinate(i,j,0);
                if(map[i][j] == '*') waters.add(new Coordinate(i,j,0));
            }
        }
    }

    static void run(){
        waterBfs();
        visit = new boolean[R][C];
        hedgehogBfs();

        System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
    }

    static void waterBfs(){
        Queue<Coordinate> q = new LinkedList<>();

        waters.forEach(coordinate -> {
            q.add(coordinate);
            visit[coordinate.r][coordinate.c] = true;
        });

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < R && nc < C){
                    if(map[nr][nc] == '.' && !visit[nr][nc]){
                        waterDistance[nr][nc] = current.depth + 1;

                        q.add(new Coordinate(nr,nc,current.depth + 1));
                        visit[nr][nc] = true;
                    }
                }
            }
        }
    }

    static void hedgehogBfs(){
        Queue<Coordinate> q = new LinkedList<>();

        q.add(S);
        visit[S.r][S.c] = true;

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < R && nc < C){
                    if(map[nr][nc] == 'D'){
                        min = Math.min(min, current.depth + 1);
                    }

                    if(map[nr][nc] == '.' && !visit[nr][nc]){
                        if(waterDistance[nr][nc] == 0 || current.depth + 1 < waterDistance[nr][nc]){
                            q.add(new Coordinate(nr,nc,current.depth + 1));
                            visit[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }

}
