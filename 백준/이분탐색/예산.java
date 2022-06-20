import java.io.*;
import java.util.*;

/**
 * [2512] [이분탐색 - 매개 변수 탐색] 예산
 *
 * 어떤 수 K 일 때, 예산 M에 제일 근접한가
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M, MAX = 0;
    static int[] nArray;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        nArray = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < N; i++){
            nArray[i] = Integer.parseInt(st.nextToken());
            MAX = Math.max(MAX,nArray[i]);
        }

        M = Integer.parseInt(in.readLine());
    }

    static void run() {
        int L = 1, R = MAX, ans = MAX;

        while(L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(int k){
        int sum = 0;
        for(int n : nArray){
            sum += Math.min(n, k);
        }

        return sum <= M;
    }

}