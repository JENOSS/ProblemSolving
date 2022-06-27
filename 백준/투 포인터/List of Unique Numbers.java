import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * [13144] [투 포인터] List of Unique Numbers
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 * L 마다 R을 최대한 옮겨서 확인
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[] A;
    static int[] COUNT;

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        A = new int[N + 1];
        COUNT = new int[100001];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        long ans = 0;
        int L, R = 0;

        for (L = 1; L <= N; L++){
            // R을 최대한 옮긴다.
            while(R + 1 <= N && COUNT[A[R + 1]] == 0){
                COUNT[A[++R]] = 1;
            }

            // 정답 갱신
            ans += R - L + 1;

            // L을 옮기면서 A[L]의 COUNT 를 감소
            COUNT[A[L]]--;
        }

        System.out.println(ans);
    }

}