import java.io.*;

/**
 * [16472] [투 포인터] 고냥이
 *
 * Keyword : 연속 부분 수열 or 순서를 지키며 차례대로, 곱의 최소
 * 1차원 배열 위에 2개의 포인터를 만들어서 범위 축소 (L,R 같은 방향 or 서로를 향해)
 * 문제에 등장하는 변수 2개의 값을 투 포인터로 표현
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();;
    }

    static int N;
    static char[] A;
    static int[] CNT;
    static int KIND = 0;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        A = new char[N];
        CNT = new int[26];

        A = in.readLine().toCharArray();
    }

    static void run(){
        int len = A.length, ans = 0;

        for (int R = 0, L = 0; R < len; R++){
            // R번째 문자를 오른쪽에 추가
            add(A[R]);

            //불가능하면 가능할 때 까지 L을 이동
            while(KIND > N){
                erase(A[L++]);
            }

            ans = Math.max(ans, R - L + 1);
        }

        System.out.println(ans);
    }

    static void add(char x){
        CNT[x - 'a']++;
        if(CNT[x - 'a'] == 1) KIND++;
    }

    static void erase(char x){
        CNT[x - 'a']--;
        if(CNT[x - 'a'] == 0) KIND--;
    }


}