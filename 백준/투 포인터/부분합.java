import java.io.*;
import java.util.StringTokenizer;

/**
 * [1806] [투 포인터] 부분 합
 *
 * O(N)
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, S;
    static int[] A;

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N + 1];

        st = new StringTokenizer(in.readLine()," ");
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        int R = 0, sum = 0, ans = -1;

        for(int L = 1; L <= N; L++){
            // L - 1 을 구간에서 제외하기
            sum -= A[L - 1];

            // R 을 옮길 수 있을 때 까지 옮기기
            while(R + 1 <= N && sum < S) sum += A[++R];

            // [L ... R] 의 합, 즉 sum 이 조건을 만족하면 정답 갱신
            if(sum >= S){
                if(ans == -1) ans = R - L + 1;
                ans = Math.min(ans, R - L + 1);
            }
        }

        System.out.println(ans == -1 ? 0 : ans);
    }
}