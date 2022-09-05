import java.io.*;

/**
 * [15988] [DP] 1,2,3 더하기 3
 *
 * 점화식 : dy[n] = dy[n - 1] + dy[n - 2] + dy[n - 3]
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        run();
        input();
    }

    static int T;
    static long[] dy = new long[1000001];
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(in.readLine());
            sb.append(dy[n]).append("\n");
        }

        System.out.print(sb);
    }

    static void run() {
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for(int i = 4; i <= 1000000; i++){
            dy[i] = (dy[i - 1] + dy[i - 2] + dy[i - 3])%1000000009;
        }
    }


}
