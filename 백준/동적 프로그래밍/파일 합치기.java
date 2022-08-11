import java.io.*;
import java.util.*;

/**
 * [11066] [DP] 파일 합치기
 *
 * 동적 프로그래밍
 * 점화식 : dy[i][j] = MIN(k) {dy[i][k] + dy[k + 1][j] + (i ~ j 파일 총량), i <= k < j}
 *      : sum[i][j] = sum[i][j - 1] + A[j]
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static int[] A;
    static int[][] dy;
    static int[][] sum;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for(int i = 0; i < T; i++){
            int size = Integer.parseInt(in.readLine());
            A = new int[size + 1];
            dy = new int[size + 1][size + 1];
            sum = new int[size + 1][size + 1];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 1; j <= size; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }

            run(size);
        }

        System.out.print(sb);
    }

    static void run(int size){
        for(int i = 1; i <= size; i++){
            for(int j = i; j <= size; j++){
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        for(int len = 2; len <= size; len++){
            for(int i = 1; i <= size - len + 1; i++){
                int j = i + len - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k + 1][j] + sum[i][j]);
                }
            }
        }

        sb.append(dy[1][size]).append("\n");

    }
}
