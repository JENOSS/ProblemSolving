import java.io.*;
import java.util.*;

/**
 * [2667] [그래프] 단지번호붙이기
 *
 * DFS 사용
 * 전체 단지를 전부 돌아봐야돼서 O(N^2)
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, cnt;
    static int[][] A;
    static boolean[][] visit;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        A = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String line = in.readLine();
            for(int j = 0; j < N; j++){
                A[i][j] = line.charAt(j) - 48;
            }
        }
    }

    static void run(){
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(A[i][j] == 1 && !visit[i][j]){
                    sum++;
                    cnt = 0;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append('\n');

        for(Integer c : list) sb.append(c).append('\n');

        System.out.print(sb);

    }

    static void dfs(int x, int y){
        cnt++;
        visit[x][y] = true;

        if(x + 1 != N && A[x + 1][y] == 1 && !visit[x + 1][y]) dfs(x + 1, y);

        if(x - 1 != -1 && A[x - 1][y] == 1 && !visit[x - 1][y]) dfs(x - 1, y);

        if(y + 1 != N && A[x][y + 1] == 1 && !visit[x][y + 1]) dfs(x,y + 1);

        if(y - 1 != -1 && A[x][y - 1] == 1 && !visit[x][y - 1]) dfs(x,y - 1);

    }

}