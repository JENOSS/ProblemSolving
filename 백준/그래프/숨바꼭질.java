import java.io.*;
import java.util.*;

/**
 * [1697] [그래프] 숨바꼭질
 *
 * keyword : 최소 연산 횟수
 * 점의 번호 : 정점 , 이동 : 간선 (+,-,*)
 * 최소 개수로 간선 이동
 * **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int MAX = 100000;
    static int MIN = Integer.MAX_VALUE;
    static int N,K;
    static boolean[] visit;

    static class Coordinate{
        int x;
        int depth;

        public Coordinate(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[MAX+1];
    }

    static void run(){
        bfs();
        System.out.println(MIN);
    }

    static void bfs(){
        if(N == K){
            MIN = 0;
            return;
        }

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(N,0));

        while(!q.isEmpty()){
            Coordinate current = q.poll();

            if(current.x == K){
                MIN = Math.min(MIN, current.depth);
                continue;
            }

            if(N < K){
                if(current.x + 1 <= MAX && !visit[current.x + 1]){
                    q.add(new Coordinate(current.x + 1, current.depth + 1));
                    visit[current.x + 1] = true;
                }
                if(current.x * 2 <= MAX && !visit[current.x * 2]){
                    q.add(new Coordinate(current.x * 2,current.depth + 1));
                    visit[current.x * 2] = true;
                }
            }

            if(current.x - 1 >= 0 && !visit[current.x - 1]){
                q.add(new Coordinate(current.x - 1, current.depth + 1));
                visit[current.x - 1] = true;
            }

        }
    }


}