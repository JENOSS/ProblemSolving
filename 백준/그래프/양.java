import java.io.*;
import java.util.*;

/**
 * [3184] [그래프] 양
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int sheepInit = 0;
    static int wolfInit = 0;

    //상하좌우
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

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String s = in.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'o') sheepInit++;
                if(map[i][j] == 'v') wolfInit++;
            }
        }
    }

    static void run(){
        StringBuilder sb = new StringBuilder();
        int sheepCount = 0;
        int wolfCount = 0;


        if(sheepInit != 0 && wolfInit != 0){
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(!visit[i][j]){
                        if(map[i][j] == 'o'){
                            StringTokenizer st = new StringTokenizer(bfs(new Coordinate(i,j),1,0), " ");
                            sheepCount += Integer.parseInt(st.nextToken());
                            wolfCount += Integer.parseInt(st.nextToken());
                        }

                        if(map[i][j] == 'v'){
                            StringTokenizer st = new StringTokenizer(bfs(new Coordinate(i,j),0,1), " ");
                            sheepCount += Integer.parseInt(st.nextToken());
                            wolfCount += Integer.parseInt(st.nextToken());
                        }
                    }
                }
            }
            sb.append(sheepCount).append(" ").append(wolfCount);
        }else{
            sb.append(sheepInit).append(" ").append(wolfInit);
        }

        System.out.println(sb);
    }

    static String bfs(Coordinate start, int sheepCount, int wolfCount){

        Queue<Coordinate> q = new LinkedList<>();
        q.add(start);
        visit[start.r][start.c] = true;

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                    if (map[nr][nc] != '#' && !visit[nr][nc]) {
                        if (map[nr][nc] == 'o') sheepCount++;
                        if (map[nr][nc] == 'v') wolfCount++;
                        q.add(new Coordinate(nr,nc));
                        visit[nr][nc] = true;
                    }
                }
            }
        }

        if(sheepCount > wolfCount){
            wolfCount = 0;
        }else{
            sheepCount = 0;
        }

        return sheepCount + " " + wolfCount;
    }




}