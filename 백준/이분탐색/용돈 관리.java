import java.io.*;
import java.util.*;

/**
 * [6236] [이분탐색 - 매개 변수 탐색] 용돈 관리
 *
 * M번 카운팅 이상을 만족시키는 최소 K 수
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M, MAX = 1;
    static int[] CASH;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        CASH = new int[N];

        for(int i = 0; i < N; i++) {
            CASH[i] = Integer.parseInt(in.readLine());
            MAX = Math.max(MAX,CASH[i]);
        }
    }

    static void run(){
        long L = MAX, R = Integer.MAX_VALUE, ans = MAX;

        while(L <= R){
            long mid = (L + R) / 2;
            if(determination(mid)){
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(long x){
        int cnt = 1, sum = CASH[0];

        for(int i = 1; i < N; i++){
            int c = CASH[i];
            if(sum + c > x){
                cnt++;
                sum = 0;

                if(cnt > M) return false;
            }
            sum+= c;
        }

        return true;
    }

}