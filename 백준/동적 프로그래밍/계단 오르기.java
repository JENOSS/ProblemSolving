import java.io.*;
import java.util.*;

/**
 * [2579] [DP] 계단 오르기
 *
 * 동적 프로그래밍
 * 점화식 : dy[i][0] (이전 계단 안 밟은 경우) = Math.max(dy[i - 2][0], dy[i - 2][1])
 *        dy[i][1] (이전 계단 밟은 경우) = dy[i - 1][0]
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int[][] dy;
    static int[] A;
    static int N;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new int[N];
        dy = new int[N][2];

        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(in.readLine());
    }

    static void run(){
        dy[0][0] = A[0];

        if(N > 1){
            dy[1][0] = A[1];
            dy[1][1] = A[0] + A[1];
        }

        for(int i = 2; i < N; i++){
            dy[i][0] = Math.max(dy[i - 2][0], dy[i - 2][1]) + A[i];
            dy[i][1] = dy[i - 1][0] + A[i];
        }

        System.out.println(Math.max(dy[N - 1][0], dy[N - 1][1]));

    }
}
