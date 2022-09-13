import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * [medium] Queen's Attack 2
 *
 * DFS로 해결 가능
 * 주의 ! board[N+1][N+1] 불가 최대 10^5 이기에 메모리 과부화
 * set 과 string 으로 이용
 * string 은 1:1, 2:1 과 같은 형태로 구현 rc 붙이면 1111 -> 11:11 / 111:1 과 같은 문제있음
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        queensAttack(4, 0, 4, 4, new ArrayList<>() );
    }

    public static int[] crossR = {-1, -1, 1, 1};
    public static int[] crossC = {-1, 1, -1, 1};

    public static int[] straightR = {-1, 1, 0, 0};
    public static int[] straightC = {0, 0, -1, 1};

    public static class Move{
        boolean isCross;
        int idx;
        int r;
        int c;

        public Move(boolean isCross, int idx, int r, int c){
            this.isCross = isCross;
            this.idx = idx;
            this.r = r;
            this.c = c;
        }
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        HashSet<String> hs = new HashSet<>();

        for(List<Integer> obstacle : obstacles){
            hs.add(String.format("%d:%d",obstacle.get(0), obstacle.get(1)));
        }

        Queue<Move> q = new LinkedList<>();

        for(int i = 0; i < 4; i++){
            int nextR = r_q + crossR[i];
            int nextC = c_q + crossC[i];

            String s = String.format("%d:%d",nextR,nextC);

            if(nextR > 0 && nextR <= n && nextC > 0 && nextC <= n && !hs.contains(s)){
                q.add(new Move(true, i, nextR, nextC));
            }
        }

        for(int i = 0; i < 4; i++){
            int nextR = r_q + straightR[i];
            int nextC = c_q + straightC[i];

            String s = String.format("%d:%d",nextR,nextC);

            if(nextR > 0 && nextR <= n && nextC > 0 && nextC <= n && !hs.contains(s)){
                q.add(new Move(false, i, nextR, nextC));
            }
        }

        int result = 0;

        while(!q.isEmpty()){
            Move current = q.poll();
            result++;

            int nextR;
            int nextC;

            if(current.isCross){
                nextR = current.r + crossR[current.idx];
                nextC = current.c + crossC[current.idx];
            } else {
                nextR = current.r + straightR[current.idx];
                nextC = current.c + straightC[current.idx];
            }

            String s = String.format("%d:%d",nextR,nextC);

            if(nextR > 0 && nextR <= n && nextC > 0 && nextC <= n && !hs.contains(s)){
                q.add(new Move(current.isCross, current.idx, nextR, nextC));
            }
        }

        return result;
    }



}
