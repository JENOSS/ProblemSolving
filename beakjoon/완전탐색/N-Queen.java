import java.io.*;

/**
 [9663] [완전탐색] N-Queen
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(ans);
    }

    static void input() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        col = new int[N+1];
    }

    static int N, ans;
    static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록

    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    static void recFunc(int row){
        if(row == N + 1){ // 1 ~ N 번 행에 대해서 성공적으로 놓았다.
            ans++;
        }else{
            for(int c = 1; c <= N; c++){
                // row 행의 c 열에 놓을 수 있으면
                if(check(row,c)){
                    col[row] = c;
                    recFunc(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    static boolean check(int r, int c){
        for(int preRow = 1; preRow <= r-1; preRow++){
            if(c == col[preRow]) return false;
            if(Math.abs(r - preRow) == Math.abs(c - col[preRow])) return false;
        }
        return true;
    }
}