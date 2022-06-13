import java.io.*;
import java.util.Arrays;

/**
 [11652] [정렬] 카드
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    static int N;
    static long[] cards;

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        cards = new long[N];
        for(int i = 0; i < N; i++){
            cards[i] = Long.parseLong(in.readLine());
        }
    }

    static void run(){
        Arrays.sort(cards);

        long mode = cards[0]; // 최빈값
        int modeCnt = 1, curCnt = 1; //최빈값의 등장 횟수, 현재값의 등장 횟수

        for(int i = 1; i < N; i++){
            if(cards[i - 1] != cards[i]) curCnt = 0;

            curCnt++;

            if(modeCnt < curCnt){
                modeCnt = curCnt;
                mode = cards[i];
            }else if(modeCnt == curCnt){
                if(mode > cards[i]){
                    mode = cards[i];
                }
            }
        }

        System.out.println(mode);
    }

}