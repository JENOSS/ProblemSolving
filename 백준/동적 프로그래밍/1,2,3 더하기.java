import java.io.*;
import java.util.*;

/**
 * [9095] [DP] 1,2,3 더하기
 *
 * 동적 프로그래밍
 * 점화식 : dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3]
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int[] dy;
    static int[] question;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(in.readLine());

        question = new int[testCase];

        for(int i = 0; i < testCase; i++) question[i] = Integer.parseInt(in.readLine());
    }

    static void run(){
        dy = new int[11];

        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for(int i = 4; i <= 10; i++){
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for(int q : question) sb.append(dy[q]).append("\n");
        System.out.print(sb);
    }

}
