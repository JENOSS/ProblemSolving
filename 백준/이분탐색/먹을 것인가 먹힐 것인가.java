import java.io.*;
import java.util.*;

/**
 * [7795] [이분탐색] 먹을 것인가 먹힐 것인가
 **/

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(in.readLine());

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine(), " ");
            for(int k = 0; k < m; k++){
                b[k] = Integer.parseInt(st.nextToken());
            }

            run(a,b);
        }

        System.out.print(ans);
    }

    static void run(int[] a, int[] b){
        Arrays.sort(b);

        int cnt = 0;
        for(int aNum : a){
            cnt += lowerBound(b, 0, b.length - 1, aNum);
        }

        ans.append(cnt).append("\n");
    }

    static int lowerBound(int A[], int L, int R, int X){
        int res = L;

        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] < X){
                res = mid + 1; // index + 1 : 개수
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return res;
    }

}