import java.io.*;
import java.util.*;

/**
 * [2805] [이분탐색 - 매개 변수 탐색] 나무 자르기
 * 매개 변수 탐색 : 정답을 '매개 변수'로 만들고 Yes/No 문제(결정 문제)로 바꿔보기
 * 모든 값에 대해서 Yes/No 를 채웠다고 생각했을 때, 정렬된 상태인가?
 * 힌트 : 최댓값/최솟값 구하기 문제 시도 가치 있음
 *
 * [매개 변수 만들기]
 * 원하는 길이 M 만큼을 얻을 수 있는 최대 높이는 얼마 ?
 * -> 어떤 높이로 잘랐을 때, 원하는 길이 M 만큼을 얻을 수 있는가 ? Yes/No
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N, M;
    static int[] trees;

    public static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(in.readLine()," ");
        for(int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());
    }

    static void run(){
        long L = 0, R = 2000000000, ans = 0;

        while(L <= R){
            int mid = (int)((L + R) / 2);
            if(determination(mid)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean determination(int H){
        long total = 0;

        for(int tree : trees){
           total += Math.max(tree - H, 0);
           if(total >= M) break;
        }

        return total >= M;
    }
}