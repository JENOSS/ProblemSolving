import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * [10870] [DP] 피보나치 수 5
 *
 *  점화식
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[] dy;

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        dy = new int[N + 1];
    }

    static void run() {
        dy[0] = 0;

        if (N > 0) {
            dy[1] = 1;

            for (int i = 2; i <= N; i++) {
                dy[i] = dy[i - 1] + dy[i - 2];
            }
        }

        System.out.println(dy[N]);
    }


}
