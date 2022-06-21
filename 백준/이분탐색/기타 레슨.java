import java.io.*;
import java.util.*;

/**
 * [2343] [이분탐색 - 매개 변수 탐색] 기타 레슨
 *
 * 어떤 수 K 일 때, 최소 길이를 갖는가
 * (주의) 어떤 수 K를 찾을 때 강의 중 가장 긴 길이보다 크거나 같아야 한다.
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M, MAX = 1;
    static int[] LECTURES;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LECTURES = new int[N];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < N; i++) {
            LECTURES[i] = Integer.parseInt(st.nextToken());
            MAX = Math.max(MAX,LECTURES[i]);
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
        int cnt = 1, sum = LECTURES[0];

        for(int i = 1; i < N; i++){
            int lecture = LECTURES[i];
            if(sum + lecture > x){
                cnt++;
                sum = 0;

                if(cnt > M) return false;
            }
            sum+= lecture;
        }

        return true;
    }

}