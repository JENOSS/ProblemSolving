import java.io.*;
import java.util.*;

/**
 * [11726] [DP] 2xN 타일링
 *
 * 동적 프로그래밍
 * 점화식 : dy[2xi] = dy[2x(i-1)] + dy[2x(i-2)] : 끝이 '|' 이거나 '='
 * --> dy[i] = dy[i-1] + dy[i-2]
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int[] dy;
    static int N;


    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
    }

    static void run(){
        dy = new int[N + 1];

        dy[1] = 1;
        if(N > 1) dy[2] = 2;

        for(int i = 3; i <= N; i++) dy[i] = (dy[i - 1] + dy[i - 2]) % 10007;

        System.out.println(dy[N]);
    }

}
