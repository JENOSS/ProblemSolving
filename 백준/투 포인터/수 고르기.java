import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * [2230] [투 포인터] 수 고르기
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 * L, R 왼쪽에서 같이 이동
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int A[];

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(in.readLine());
    }

    static void run(){
        Arrays.sort(A);

        int R = 1, ans = Integer.MAX_VALUE;

        for(int L = 0; L < N - 1; L++){

            while(R < N && Math.abs(A[L] - A[R]) < M){
                R++;
            }

            if(R == N) break;

            ans = Math.min(ans, Math.abs(A[L] - A[R]));
        }

        System.out.println(ans);
    }

}