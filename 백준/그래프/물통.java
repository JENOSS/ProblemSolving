import java.io.*;
import java.util.*;

/**
 * [2251] [그래프] 물통
 *
 * BFS 사용
 * (a,b,c) -> (a',b',c') 하나의 정점과 간선으로 생각
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static class State{
        int X[];

        State(int[] _X){
            X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = _X[i];
        }

        State move(int from, int to){
            int[] newX = new int[]{X[0], X[1], X[2]};

            if(X[from] + X[to] <= limit[to]){ // 옮길 수 있음
                newX[to] = newX[from] + newX[to];
                newX[from] = 0;
            }else{
                newX[from] -= limit[to] - newX[to];
                newX[to] = limit[to];
            }

            return new State(newX);
        }
    }

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        limit = new int[3];
        possible = new boolean[201];
        visit = new boolean[201][201][201];

        for(int i = 0; i < 3; i++) limit[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        bfs(0,0,limit[2]);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < possible.length; i++){
            if(possible[i]) sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs(int a, int b, int c){
        Queue<State> q = new LinkedList<>();

        State start = new State(new int[]{a,b,c});
        q.add(start);
        visit[a][b][c] = true;

        while(!q.isEmpty()){
            State current = q.poll();
            if(current.X[0] == 0) possible[current.X[2]] = true;

            for(int from = 0; from < 3; from++){
                for(int to = 0; to < 3; to++){
                    if(from == to) continue;

                    State next = current.move(from,to);

                    if(!visit[next.X[0]][next.X[1]][next.X[2]]){
                        q.add(next);
                        visit[next.X[0]][next.X[1]][next.X[2]] = true;
                    }
                }
            }
        }

    }


}