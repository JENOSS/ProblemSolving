import java.io.*;
import java.util.*;

/**
 * [17266] [이분탐색 - 매개 변수 탐색] 어두운 굴다리
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int[] LIGHTS;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        LIGHTS = new int[M];

        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < M; i++) LIGHTS[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        int L = 1, R = N, ans = 0;

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
        int L = 0;

        for(int light : LIGHTS){
            if (L < light) {
                int d = Math.abs(L - light);
                if (d > x) return false;
            }
            L = light + x;
        }

        return L >= N;
    }

}