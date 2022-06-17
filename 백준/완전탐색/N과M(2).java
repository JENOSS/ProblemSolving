import java.io.*;
import java.util.*;

/**
 [15650] [완전탐색] N과 M(2)
 **/

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.print(sb.toString());
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    // Recurrence Function ( 재귀 함수 )
    // 만약 M개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것 !
    // 아직 M개를 고르지 않음 => K 번째부터 M번째 원소를 족너에 맞게 고르는 모든 방법을 시도한다.
    static void recFunc(int k){
        if (k == M + 1){ // 다 골랐다 !
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k-1]+1;
            for (int cand = start; cand <= N; cand++){
                // k 번째에 cand가 올 수 있으면
                selected[k] = cand;

                // k+1 번부터 M번 까지 채워주는 함수를 호출해준다.
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }
}