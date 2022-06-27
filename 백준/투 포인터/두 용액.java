import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [2470] [투 포인터] 두 용액
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 **/

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[] A;

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        Arrays.sort(A, 1, N + 1);

        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 1, R = N;

        while (L < R){

            if(bestSum >= Math.abs(A[L] + A[R])){
                bestSum = Math.abs(A[L] + A[R]);
                v1 = A[L];
                v2 = A[R];
            }

            if(A[L] + A[R] < 0){
                // 최소 입장에서 최선책
                L++;
            }else if(A[L] + A[R] > 0){
                // 최대 입장에서 최선책
                R--;
            }else{
                break;
            }
        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb);
    }

}