import java.io.*;

/**
 * [레벨 2] [완전탐색] 피로도
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
    }

    public static int max = 0;

    public int solution(int k, int[][] dungeons) {

        for(int i = 0; i < dungeons.length ; i++){
            search(k, i, 1, new boolean[dungeons.length], dungeons);
        }

        return max;
    }

    public void search(int k, int idx, int depth, boolean[] visit, int[][] dungeons){
        visit[idx] = true;
        k -= dungeons[idx][1];
        max = Math.max(max, depth);

        for(int i = 0 ; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                search(k, i, depth + 1, visit, dungeons);
                visit[i] = false;
            }
        }
    }

}
