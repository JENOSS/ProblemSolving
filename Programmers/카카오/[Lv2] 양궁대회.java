import java.io.*;
import java.util.*;

/**
 * [카카오] [Lv 2] 양궁 대회
 *
 * 백트래킹
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }

    public static int[] apeach;
    public static int[] ryan = new int[11];
    public static int N;
    public static int maxDiff = -1;
    public static List<int[]> answer = new ArrayList<>();

    public static int[] solution(int n, int[] info) {
        apeach = info;
        N = n;
        dfs(0, 0);

        if(maxDiff == -1) return new int[]{ -1 };
        answer.sort((o1, o2) -> {
            for(int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });

        return answer.get(0);

    }

    public static void dfs(int depth, int start){
        if(depth == N){
            int rSum = 0;
            int aSum = 0;

            for(int i = 0; i < 10; i ++){
                if(apeach[i] ==0 && ryan[i] ==0) continue;
                if(apeach[i] >= ryan[i]){
                    aSum += 10 - i;
                } else{
                    rSum += 10 - i;
                }
            }

            if(rSum > aSum){
                int diff = rSum - aSum;
                if(maxDiff < diff){
                    maxDiff = diff;
                    answer.clear();
                    answer.add(ryan.clone());
                }else if(maxDiff == diff){
                    answer.add(ryan.clone());
                }
            }

            return;
        }


        for(int i = start; i < 11; i++){
            ryan[i]++;
            dfs(depth + 1, i);
            ryan[i]--;
        }
    }
}

