import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * [2473] [투 포인터] 세 용액
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 * 한 개의 용액 : X
 * 나머지 두 용액 : L = X Index + 1, R = N - 1
 * 세 가지 수를 더하면 최대 30억 이므로 sum 은 long 사용
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int A[];

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        Arrays.sort(A);

        long sum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3= 0 ;

        for(int xIdx = 0; xIdx < N - 1; xIdx++){
            int X = -A[xIdx];
            int L = xIdx + 1;
            int R = N - 1;

            while(L < R){
                if(Math.abs((long)X - (long)(A[L] + A[R])) < sum){
                    v1 = A[xIdx];
                    v2 = A[L];
                    v3 = A[R];
                    sum = Math.abs((long)X - (long)(A[L] + A[R]));
                }

                if(A[L] + A[R] < X){
                    L++;
                }else if(A[L] + A[R] > X){
                    R--;
                }else{
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(v1).append(' ').append(v2).append(' ').append(v3);
        System.out.println(sb);
    }



}