import java.io.*;
import java.util.StringTokenizer;

/**
 * [11728] [투 포인터] 배열 합치기
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 * 자바의 Arrays.sort 는 NlogN 이므로 그냥 정렬해도 정답이긴함
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int[] A, B;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        StringBuilder sb = new StringBuilder();

        int R = 0;

        for(int L = 0; L < N; L++){

            while(R < M && A[L] > B[R]){
                sb.append(B[R]).append(' ');
                R++;
            }

            sb.append(A[L]).append(' ');
        }

        for(int r = R; r < M; r++) sb.append(B[r]).append(' ');

       System.out.println(sb);
    }

}