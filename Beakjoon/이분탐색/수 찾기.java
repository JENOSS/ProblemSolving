import java.io.*;
import java.util.*;

/**
 * [1920] [이분탐색] 수 찾기
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int[] A, B;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(in.readLine());
        B = new int[M];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void run(){
        Arrays.sort(A);

        for(int i = 0; i < M; i++){
            if(determination(B[i])){
                ans.append(1).append("\n");
            }else{
                ans.append(0).append("\n");
            }
        }

        System.out.print(ans);
    }

    static boolean determination(int x){
        int L = 0, R = N - 1;
        boolean isExist = false;

        while (L <= R){
            int mid = (L + R) / 2;
            if(A[mid] == x){
                isExist = true;
                break;
            }else if(A[mid] < x){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return isExist;
    }
}