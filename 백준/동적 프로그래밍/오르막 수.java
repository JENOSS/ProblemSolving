import java.io.*;
import java.util.*;

/**
 * [11057] [DP] 오르막 수
 *
 * 동적 프로그래밍
 * 점화식 : dy[i][last] = dy[i - 1][0] + dy[i - 1][1] + dy[i - 1][2] ... + dy[i - 1][j]
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[][] dy;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        dy = new int[N + 1][10];
    }

    static void run(){
        if(N < 2){
            System.out.println(N == 1 ? 10 : 0);
            return;
        }

        for(int i = 0; i <= 9; i++) {
            dy[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int last = 0; last <= 9; last++){
                for(int k = 0; k <= last; k++){
                    dy[i][last] += dy[i - 1][k];
                    dy[i][last] %= 10007;
                }
            }
        }

        int ans =  0;
        for(int num = 0; num <= 9; num++){
            ans += dy[N][num];
            ans %= 10007;
        }

        System.out.println(ans);
    }
}
