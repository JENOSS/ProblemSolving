import java.io.*;
import java.util.*;

/**
 * [7569] [그래프] 토마토
 *
 * bfs 를 통한 depth 계산
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int X, Y, Z;
    static int[][][] box;
    static boolean[][][] visit;
    static ArrayList<Tomato> starts;
    static int total = 0;

    //상하좌우위아래
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Tomato{
        int x,y,z;
        int depth;

        public Tomato(int x, int y, int z, int depth) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        box = new int[Z][Y][X];
        visit = new boolean[Z][Y][X];
        starts = new ArrayList<>();

        for(int i = 0; i < Z; i++){
            for(int j = 0; j < Y; j++){
                st = new StringTokenizer(in.readLine(), " ");
                for(int k = 0; k < X; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){
                        starts.add(new Tomato(k,j,i,0));
                        visit[i][j][k] = true;
                    }
                    if(box[i][j][k] == 0) total++;
                }
            }
        }
    }

    static void run(){
        System.out.println(bfs());
    }

    static int bfs(){
        int visitCount = 0;
        int lastDepth = 0;

        Queue<Tomato> q = new LinkedList<>(starts);

        while(!q.isEmpty()){
            Tomato current = q.poll();

            for(int i = 0; i < 6; i++){
                int nz = current.z + dz[i];
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if(nz >= 0 && ny >= 0 && nx >=0 && nz < Z && ny < Y && nx < X){
                    if(box[nz][ny][nx] == 0 && !visit[nz][ny][nx]){
                        q.add(new Tomato(nx, ny, nz, current.depth + 1));
                        visit[nz][ny][nx] = true;
                        visitCount++;

                        if(visitCount == total){
                            lastDepth = current.depth + 1;
                            q.clear();
                        }

                    }
                }
            }

        }

        return visitCount == total ? lastDepth : -1;

    }
}
