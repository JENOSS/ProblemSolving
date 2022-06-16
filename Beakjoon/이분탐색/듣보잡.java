import java.io.*;
import java.util.*;

/**
 * [1764] [이분탐색] 듣보잡
 * 해시도 가능
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static String[] A, B;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new String[N];
        B = new String[M];

        for(int i = 0 ; i < N; i++){
            A[i] = in.readLine();
        }

        for(int i = 0; i < M; i++){
            B[i] = in.readLine();
        }
    }

    static void run(){
        int size = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < M; i++){
            if(determination(B[i])){
                size++;
                ans.append(B[i]).append("\n");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n").append(ans);
        System.out.print(sb);
    }

    static boolean determination(String x){
        int L = 0, R = N - 1;
        boolean isExist = false;

        while (L <= R){
            int mid = (L + R) / 2;
            if(A[mid].compareTo(x) == 0){
                isExist = true;
                break;
            }else if(A[mid].compareTo(x) < 0){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return isExist;
    }
}