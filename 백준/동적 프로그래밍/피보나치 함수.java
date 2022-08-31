import java.io.*;

/**
 * [1003] [DP] 피보나치 함수
 *
 * 동적 프로그래밍
 * 점화식 :  dy[i][0] = dy[i - 1][0] + dy[i - 2][0];
 *         dy[i][1] = dy[i - 1][1] + dy[i - 2][1];
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
    }

    static int[][] dy;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        dy = new int[41][2];
        setDy();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(in.readLine());
            sb.append(dy[n][0]).append(" ").append(dy[n][1]).append("\n");
        }

        System.out.print(sb);
    }

    static void setDy(){
        dy[0][0] = 1;
        dy[1][1] = 1;

        for(int i = 2; i <= 40; i++){
            dy[i][0] = dy[i - 1][0] + dy[i - 2][0];
            dy[i][1] = dy[i - 1][1] + dy[i - 2][1];
        }
    }

}
