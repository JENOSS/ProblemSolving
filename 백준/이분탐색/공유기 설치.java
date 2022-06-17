import java.io.*;
import java.util.*;

/**
 * [2110] [이분탐색 - 매개 변수 탐색] 공유기 설치
 * 매개 변수 탐색 : 정답을 '매개 변수'로 만들고 Yes/No 문제(결정 문제)로 바꿔보기
 * 모든 값에 대해서 Yes/No 를 채웠다고 생각했을 때, 정렬된 상태인가?
 * 힌트 : 최댓값/최솟값 구하기 문제 시도 가치 있음
 *
 * [매개 변수 만들기]
 * c개의 공유기를 설치했을 때, 최대 인접거리는 얼마 ?
 * -> 어떤 거리 만큼은 거리를 둘 때 공유기 C개를 설치 할 수 있는가 ? Yes/No
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, C;
    static int[] homes;

    public static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int[N];

        for(int i = 0; i < N; i++) homes[i] = Integer.parseInt(in.readLine());
    }

    static void run(){
        Arrays.sort(homes);

        int L = 1, R = 1000000000, ans = 0;

        while(L <= R){
            int mid = (L + R) / 2;

            if(determination(mid)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(int D){
        int cnt = 1, last = homes[0];

        for (int i = 1; i < N; i++){
            if(homes[i] - last < D) continue;

            last = homes[i];
            cnt++;

            if(cnt == C) return true;
        }

        return false;
    }
}