import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * [medium] [54] Spiral Matrix
 *
 * 완전 탐색으로 구현 
 *
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print(spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}));
    }

    public static List<Integer> answer = new ArrayList<>();
    public static boolean[][] visit;
    public static int direction = 0;

    //right, down, left, up
    public static int[] directionR = {0, 1, 0 , -1};
    public static int[] directionC = {1, 0, -1, 0 };

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        visit = new boolean[n + 1][m + 1];

        int nextR = 0;
        int nextC = 0;

        for(int count = 0; count < n*m ; count++){
            answer.add(matrix[nextR][nextC]);
            visit[nextR][nextC] = true;

            int currentR = nextR;
            int currentC = nextC;

            nextR = nextR + directionR[direction];
            nextC = nextC + directionC[direction];

            // if nextR and nextC has a problem
            if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || visit[nextR][nextC]){
                direction = (direction + 1) % 4;

                nextR = currentR + directionR[direction];
                nextC = currentC + directionC[direction];
            }

        }

        return answer;

    }
}
