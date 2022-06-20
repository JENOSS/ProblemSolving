import java.io.*;
import java.util.*;

/**
 * [10816] [이분탐색] 숫자 카드 2
 * 해쉬 가능
 **/

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int A[], B[];

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(in.readLine());
        B = new int[M];
        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        Arrays.sort(A);

        for(int b : B){
            sb.append(upperBound(b) - lowerBound(b)).append(' ');
        }

        System.out.println(sb);
    }

    static int upperBound(int X){
        int L = 0, R = N - 1, ans = N;

        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] > X){
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        return ans;
    }

    static int lowerBound(int X){
        int L = 0, R = N - 1, ans = N;

        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] >= X){
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        return ans;
    }
}