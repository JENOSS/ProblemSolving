import java.io.*;
import java.util.*;

/**
 * [1654] [이분탐색 - 매개 변수 탐색] 랜선 자르기
 *
 * 원하는 개수 N개 만큼 얻을 수 있는 길이 H는 ?
 * -> 어떤 길이 H 일 때, N만큼 얻을 수 있는 가
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int K, N, MAX = 0;
    static int[] kArray;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        kArray = new int[K];
        for(int i = 0; i < K; i++){
            kArray[i] = Integer.parseInt(in.readLine());
            MAX = Math.max(MAX,kArray[i]);
        }
    }

    static void run() {
        long L = 1, R = MAX, ans = 0;

        while (L <= R){
            long mid = (L + R) / 2;
            if(determination(mid)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(long h){
        long sum = 0;

        for(int k : kArray){
            sum += k / h;
            if(sum >= N) return true;
        }

        return false;
    }
}