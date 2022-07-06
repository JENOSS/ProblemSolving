import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * [3273] [투 포인터] 두 수의 합
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

    static int N, X;
    static int A[];

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        X = Integer.parseInt(in.readLine());
    }

    static void run(){
        Arrays.sort(A);

        int ans = 0;

        for(int L = 0; L < N; L++){
            if(L <= X/2 && determination(L)) ans++;
        }

        System.out.println(ans);
    }

    static boolean determination(int L){
        int R = L + 1;

        while(R < N && A[L] + A[R] < X){
            R++;
        }

        if(R < N){
            return A[L] + A[R] == X;
        }else{
            return false;
        }

    }

}