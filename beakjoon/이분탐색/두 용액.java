import java.io.*;
import java.util.*;

/**
 * [2470] [이분탐색] 두 용액
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[] liquids;

    static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        liquids = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0 ; i < N; i++) liquids[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        Arrays.sort(liquids);

        int bestSum = Integer.MAX_VALUE; // 0에 가장 가까운 합
        int v1 = 0, v2 = 0; // bestSum 을 만든 두 용액

        for(int left = 0; left < N - 1; left++){
            int candidate = lowerBound(liquids, left + 1, N - 1, -liquids[left]);

            if(left < candidate - 1 && Math.abs(liquids[left] + liquids[candidate - 1]) < bestSum){
                bestSum = Math.abs(liquids[left] + liquids[candidate - 1]);
                v1 = liquids[left];
                v2 = liquids[candidate - 1];
            }

            if(candidate < N && Math.abs(liquids[left] + liquids[candidate]) < bestSum){
                bestSum = Math.abs(liquids[left] + liquids[candidate]);
                v1 = liquids[left];
                v2 = liquids[candidate];
            }
        }

        ans.append(v1).append(" ").append(v2);
        System.out.println(ans);
    }

    static int lowerBound(int[] A, int L, int R, int X){

        int res = R;

        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] < X){
                L = mid + 1;
            }else{
                res = mid;
                R = mid - 1;
            }
        }

        return res;
    }

}