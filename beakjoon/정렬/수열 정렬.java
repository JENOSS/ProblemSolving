import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 [1015] [정렬] 수열 정렬
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[] P;
    static NumAndIdx[] A;

    static class NumAndIdx implements Comparable<NumAndIdx>{

        /**
         * @param num A[idx]의 값
         * @param idx A 배열의 IDX
         */
        public int num, idx;

        @Override
        public int compareTo(NumAndIdx o) {
            if(num != o.num){
                return num - o.num;
            }else{
                return idx - o.idx;
            }
        }
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new NumAndIdx[N];
        P = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        for(int i = 0 ; i < N; i++){
            A[i] = new NumAndIdx();
            A[i].num = Integer.parseInt(st.nextToken());
            A[i].idx = i;
        }
    }

    static void run(){
        Arrays.sort(A);

        for(int i = 0; i < N; i++){
            P[A[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : P){
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}