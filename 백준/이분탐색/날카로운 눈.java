import java.io.*;
import java.util.StringTokenizer;

/**
 * [1637] [이분탐색 - 매개 변수 탐색] 날카로운 눈
 *
 * x 값 이하의 수들의 개수가 홀수인지 확인
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, MAX = 0;
    static int[][] A;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        A = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < 3; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                if(j == 1) MAX = Math.max(MAX, A[i][j]);
            }
        }
    }

    static void run(){
        long L = 1, R = MAX, ans = 0, ansCnt = 0;

        while(L <= R){
            long mid = (L + R) / 2;
            if(determination((int)mid)){
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        if(ans == 0){
            System.out.println("NOTHING");
        }else{
            for(int i = 0; i < N; i++){
                int a = A[i][0];
                int c = A[i][1];
                int b = A[i][2];

                if(a <= ans && ans <= c && (ans - a) % b == 0){
                    ansCnt++;
                }
            }
            System.out.println(ans + " " + ansCnt);
        }
    }

    static boolean determination(int X){
        long sum = 0;

        for(int i = 0; i < N; i++){
            sum+= count(A[i][0], A[i][1], A[i][2], X);
        }

        return sum % 2 == 1;
    }

    static int count(int A, int C, int B, int X){
        // A, A+B, ..., A+KB<=C 중 X 이하의 수가 몇개 있나 ?
        if (X < A) return 0;
        if (C < X) return (C - A) / B + 1;
        return (X - A) / B + 1;
    }

}