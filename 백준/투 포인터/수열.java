import java.io.*;
import java.util.StringTokenizer;

/**
 * [2559] [투 포인터] 수열
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 * 초기 최소값을 MIN_VALUE 로 설정하기 Math.max(0, 음수 정답) 해결 위해
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, K;
    static int[] A;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1];

        st = new StringTokenizer(in.readLine()," ");
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        int R = 0, sum = 0, cnt = 1, ans = Integer.MIN_VALUE;

        for(int L = 1; L + K - 1 <= N; L++){
            sum -= A[L - 1];
            cnt--;

            while(R + 1 <= N && cnt < K){
                sum += A[++R];
                cnt++;
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

}