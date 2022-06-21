import java.io.*;
import java.util.*;

/**
 * [13702] [이분탐색 - 매개 변수 탐색] 이상한 술집
 *
 * K개 이상의 카운팅을 만들 수 있는 최소값
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, K, MAX = 1;
    static int[] LIQUORS;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        LIQUORS = new int[N];

        for(int i = 0; i < N; i++) {
            LIQUORS[i] = Integer.parseInt(in.readLine());
            MAX = Math.max(MAX,LIQUORS[i]);
        }
    }

    static void run(){
        long L = 1, R = MAX, ans = 0;

        while(L <= R){
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

    static boolean determination(long x){
        long cnt = 0;

        for(int liquor : LIQUORS){
            cnt += liquor / x;
            if(cnt >= K) return true;
        }

        return false;
    }

}