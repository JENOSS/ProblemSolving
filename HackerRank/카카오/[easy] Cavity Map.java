import java.io.*;
import java.util.*;


/**
 * [카카오] [easy] Electronics Shop
 *
 * 완전 탐색
 **/

public class Main {

    public static void main(String[] args) throws IOException {
    }

    //up, down , left, right
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static List<String> cavityMap(List<String> grid) {
        char[][] map = new char[grid.size()][grid.size()];

        for(int i = 0; i < grid.size(); i++) map[i] = grid.get(i).toCharArray();

        for(int r = 1; r < grid.size() - 1; r++){
            for(int c = 1; c < grid.size() - 1; c++){
                int current = map[r][c] - 48;

                int trueCnt = 0;
                for(int i = 0 ; i < 4; i++){
                    int compareR = r + dr[i];
                    int compareC = c + dc[i];
                    int compare = map[compareR][compareC] - 48;

                    if(compare < current) trueCnt++;
                }

                if(trueCnt == 4) map[r][c] = 'X';
            }
        }

        List<String> answer = new ArrayList<>();
        for(char[] m : map){
            StringBuilder sb = new StringBuilder();
            for(char c : m){
                sb.append(c);
            }
            answer.add(sb.toString());
        }

        return answer;
    }
}

