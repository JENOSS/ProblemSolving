import java.io.*;
import java.util.StringTokenizer;

/**
 * [15565] [투 포인터] 귀여운 라이언
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, K, LION_COUNT;
    static int[] A;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        int ans = Integer.MAX_VALUE;

       for(int L = 0, R = 0; L + K <= N; L++){

           if(A[L] != 1) continue;

           while(R < N && LION_COUNT < K){
               if(A[R] == 1) LION_COUNT++;
               R++;
           }

           if(LION_COUNT == K){
               ans = Math.min(ans,R - L);
           }

           LION_COUNT--;
       }

       if(ans == Integer.MAX_VALUE) ans = -1;
       System.out.println(ans);
    }

}