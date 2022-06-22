import java.io.*;

/**
 * [1300] [이분탐색 - 매개 변수 탐색] K번째 수
 *
 * B[K] = S 일 때, S보다 작거나 같은수가 K개 이상이여야 한다.
 * S는 K보다 작거나 같다.
 * 각 행에서 S보다 작은 수의 개수는 N, S/행 중 작은 수이다.
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, K;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        K = Integer.parseInt(in.readLine());
    }

    static void run(){
        int L = 1, R = K, ans = 0;

        while(L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)){
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(int x){
        long sum = 0;

        for(int i = 1; i <= N; i++){
            sum+= Math.min(N, x / i);
            if(sum >= K) return true;
        }

        return false;
    }

}