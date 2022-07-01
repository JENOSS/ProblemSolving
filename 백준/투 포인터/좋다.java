import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [1253] [투 포인터] 좋다
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 * 최소 + 최대 < x : 최소 입장에선 최적 최소 삭제
 * 최소 + 최대 > x : 최대 입장에선 최적 최대 삭제
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static int[] A;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        Arrays.sort(A);

        int cnt = 0;

        for(int i = 0; i < N; i++) if(determination(i)) cnt++;

        System.out.println(cnt);
    }

    static boolean determination(int targetIdx){
        int L = 0, R = N - 1;
        int x = A[targetIdx];

        while(L < R){
            if(L == targetIdx) L++;
            else if(R == targetIdx) R--;
            else{
                if(A[L] + A[R] > x) R--; // 최대 입장에서 최적
                else if(A[L] + A[R] < x) L++; // 최소 입장에서 최적
                else return true;
            }
        }

        return false;
    }

}