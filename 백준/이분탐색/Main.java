import java.io.*;
import java.util.*;

/**
 * [3273] [이분탐색] 두 수의 합
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, X;
    static int[] A;

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

        int cnt = 0;

        for(int i = 0 ; i < N-1; i++){
            int x = X - A[i];
            if(x < 1) continue;
            if(determination(i + 1, x)) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean determination(int left, int x){
        int L = left, R = N - 1;
        boolean result = false;

        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] == x){
                result = true;
                break;
            }else if(A[mid] < x){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return result;

    }

}