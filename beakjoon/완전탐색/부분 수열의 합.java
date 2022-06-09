import java.io.*;
import java.util.StringTokenizer;

/**
 [1182] [완전탐색] 부분 수열의 합
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1,0);
        // 진 부분집합만 다루도록
        if(S == 0) ans--;

        System.out.println(ans);
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
    }

    static int N, S, ans;
    static int[] nums;

    // k번째 원소를 포함시킬 지 정하는 함수
    // value:= k-1 번째 원소까지 골라진 원소들의 합
    static void recFunc(int k, int value){
        if(k == N + 1){
            // value 가 S 랑 같은 지 확인하기
            if(value == S) ans++;
        }else{
            // k 번째 원소를 포함시킬 지 결정하고 재귀호출
            // 포함
            recFunc(k + 1, value + nums[k]);

            // 포함 x
            recFunc(k + 1,value);
        }
    }

}